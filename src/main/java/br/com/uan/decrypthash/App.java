package br.com.uan.decrypthash;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import java.util.List;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.google.code.commons.checksum.digest.DigestUtils;

public class App
{
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        // availableAlgorithms();

        // Suportando o RIPEMD-320 pois a OpenJDK não vem com esse algoritmo.
        Security.addProvider(new BouncyCastleProvider());
        // System.out.println(DigestUtils.md5Hex("jesus"));

        List<String> knowHashs = Arrays.asList("1D34CD67A5B938A0DD1D255D289C23345DC77E166CFDF2173101B0D92BA902136FAB27670D01815A",
                "61A985ED059A72AA2EF1EDC1AF00118554DA92D414B04B6B3E547CBDD45DE063B1E21DD747910111",
                "61A985ED059A72AAD810426917B8BEC3F6CDBEB0310571ABCF504FDFC6165B538ABC262942B681EC",
                "61A985ED059A72AA8EA20BE30346A05B7E428EC7C1083926C9BD2A303422CB08932F8DB6600709C6",
                "965BFA38115D98C7309AFE71903C320C3B7663C14E57498C89FD7B8609E3B4A3760F8FDF9E548B07",
                "17207111CAAB4AFC60AFE9FE4F532315F568C9EB1B647BA238E1DE40438CA429459E38F7DAC0105C",
                "17207111CAAB4AFC1B75A6B3460BAEE17DD5463A1280A2ED5757F31D9C0518E3AA4C06872C201A52",
                "17207111CAAB4AFCDC587C30FB5E8A3173D28F63C262059F880B5C162AE54829A9B5C0FF92EF65E5A1F610665785BAF725A4EEC1D0F39A55",
                "1D34CD67A5B938A0A6BBCE49B980E54EF9C2E3C22363D303DE2726F77E31CA77BE2C454D6BB33D2A",
                "D5FB49E3D59F080AE5AADB62C812D3BF3C6A345F9BA90B6B365F57C235B008334CD386610BDF9176",
                "965BFA38115D98C7309AFE71903C320C3B7663C14E57498C89FD7B8609E3B4A3760F8FDF9E548B07",
                "61A985ED059A72AA12B97953CED1ACA6670CE3386C0AA52DEDBC3F08B7949F07A6AF10FBFAADDF98",
                "38379084828BC35EFAC985CD1737D16233F4201254DAF5A458E0DF9641C0553A41F0617EF39CBE2E",
                "38379084828BC35E955C21E58236F974DF21B9C27305FD353425195E57F3D2F366702C248D14E0FD",
                "61A985ED059A72AAD810426917B8BEC3F6CDBEB0310571ABCF504FDFC6165B538ABC262942B681EC",
                "1D34CD67A5B938A0827F313E8BB87CE521CDBAF3BE308E4787EF420186F20E56D5CF78E9915AA498",
                "D5FB49E3D59F080ACEF8EDA3440085F98EF60D68CF5AF3D1D4D02677BCAC8E67F27C7D789724E06A",
                "1D34CD67A5B938A085FB81961D200C34AF314DEC58B5999AD54CBE1AC0B619EEFE8A5C9FD817388B",
                "38379084828BC35E5F5E91D26A7BDAF1BF2649E36B959168173AEA967875556FD3CD6D520F0AD6B8",
                "1D34CD67A5B938A0B39428F4AFE5BF4BF0F89DD81EAF57E9D34506EDC2C905660D362BF5D012A995",
                "D5FB49E3D59F080A9F7FBBD4153BCC96D64C74DB46E4ACCF8697F5A16CBA04F37358707D93E5C927",
                "17207111CAAB4AFC1A8AB7220F63646919AB9C4689DD59D3B2BE8D8AD482723EBA326CA9EA84163D",
                "1D34CD67A5B938A0AF6D37507C8F0C897DC1A1D8D51D8975B4E563CD0694E78FA4B00F1368CF5A2E");

        for (long i = 66423889000L; i < 878511700470100L; i++) {
            if (i % 10000 == 0) {
                System.out.println(i);
            }
            String hash = DigestUtils.ripemd320Hex(String.valueOf(i));
            if (knowHashs.contains(hash)) {
                System.out.println("HASH ENCONTRADO!!!!");
                System.out.println("Valor = " + i);
                System.out.println("Hash da URL = " + knowHashs.get(knowHashs.indexOf(hash)));
            }
        }
    }

    protected static void availableAlgorithms() {
        for (Provider provider : Security.getProviders()) {
            System.out.println("Provider: " + provider.getName());
            for (Provider.Service service : provider.getServices()) {
                System.out.println("  Algorithm: " + service.getAlgorithm());
            }
        }
    }
}
