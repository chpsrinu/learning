import java.util.HashSet;
import java.util.Set;

public class Sample2 {

	public enum PlatformFamily {

        VMANAGE("vmanage"),
        VEDGE_X86("vedge-x86"),
        VEDGE_MIPS("vedge-mips"),
        VEDGE_ASR_1000("asr1000"),
        VEDGE_ASR_1001X("asr1001x"),
        VEDGE_ASR_1002X("asr1002x"),
        VEDGE_ASR_1000RPX86("asr1000rpx86"),
        VEDGE_IR_1101("ir1101"),
        VEDGE_IR_1800("ir1800"),
        VEDGE_ISR_4200("isr4200"),
        VEDGE_ISR_4300("isr4300"),
        VEDGE_ISR_4400("isr4400"),
        VEDGE_ISR_4461("isr4400v2"),
        VEDGE_ISR_1100_BE("isr1100be"),
        VEDGE_C8000_BE("c8000be"),
        VEDGE_ISR_V("isrv"),
        VEDGE_TSN_1100("c1100"),
        VEDGE_CSR_1000V("csr1000v"),
        VEDGE_C8500("c8500"),
        VEDGE_ESR_6300("c6300"),
        VEDGE_C8000_V("c8000v"),
        VEDGE_C8000_AEP("c8000aep"),
        VEDGE_C8000_AES("c8000aes"),
        NFVIS_SDWAN_NH("NFVIS-SDWAN-NH"),
        NFVIS_SDWAN_BRANCH("NFVIS-SDWAN-BRANCH");

        private String family;

        PlatformFamily(String family) {
            this.family = family;
        }

        public String getFamily() {
            return family;
        }

        public static PlatformFamily findPlatformFamily(String family) {
            for (PlatformFamily type : PlatformFamily.values()) {
                if (type.getFamily().equals(family)) {
                    return type;
                }
            }
            return null;
        }

        public static Set<String> getAllPlatformFamilyTypes() {
            Set<String> types = new HashSet<>();
            for (PlatformFamily type : PlatformFamily.values()) {
                types.add(type.getFamily());
            }
            return types;
        }

        
    }
	public static void main(String[] args) {
        System.out.println(PlatformFamily.findPlatformFamily("asr1000rpx86"));
    }
}
