package learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

//https://leetcode.com/problems/accounts-merge/
public class AccountMerge {
//accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
	public static List<List<String>> accountMerge(List<List<String>> accounts) {
		Map<String, String> emailToName = new HashMap<>();
		Map<String, ArrayList<String>> graph = new HashMap<>();
		for (List<String> account: accounts) {
			String name = "";
			for (String email: account) {
				if (name== "") {
					name = email;
					continue;
				}
				graph.computeIfAbsent(email, x->new ArrayList<String>()).add(account.get(1));
				graph.computeIfAbsent(account.get(1), x->new ArrayList<String>()).add(email);
				emailToName.put(email, name);
			}
		}
		
		Set<String> seen = new HashSet<>();
		List<List<String>> ans = new ArrayList<>();
		for (String email: graph.keySet()) {
			if (!seen.contains(email)) {
				seen.add(email);
				Stack<String> stack = new Stack<>();
				stack.push(email);
				List<String> component = new ArrayList<>();
				while (!stack.empty()) {
					String node = stack.pop();
					component.add(node);
					for (String nei: graph.get(node)) {
						if(!seen.contains(nei)) {
							seen.add(nei);
							stack.push(nei);
						}
					}
				}
				Collections.sort(component);
				component.add(0,emailToName.get(email));
				ans.add(component);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		List<List<String>> mainList = new ArrayList<>();
		List<String> list = new ArrayList<>();
		list.add("John");
		list.add("johnsmith@mail.com");
		list.add("john00@mail.com");
		mainList.add(list);
		List<String> list2 = new ArrayList<>();
		list2.add("John");
		list2.add("johnnybravo@mail.com");
		mainList.add(list2);
		System.out.println(accountMerge(mainList));
	}
}
