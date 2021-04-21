package test.java;

import org.apache.commons.lang3.StringUtils;
import org.germain.tool.ManaBox;
import org.junit.Assert;
import org.junit.Test;
import tools.TransCoder;

public class ReadKeyTest {
    @Test
    public void readKeyTest() {
        // La clé cryptée donnée plus haut
        String keyCrypted = "6Qe0IsEEH1utWRe7UKzGMiDTytOB3HS1dEfIB4imna3IRHXHRn5ZrvKFEcPjmPgKYGuytG+gDAl1m2DdHalJQg==";
        // La clé décryptée que nous devrions obtenir
        String keyDecrypted = "CFfrkowl.aDzyS:eHjsGPZgMApWvRYVmtnK!BuU IQiEXTxbqhLdNJO,'c";
        // le test d'égalité entre la clé attendue et la sortie de la méthode de la librairie. Si le décryptage ne fonctionne pas nous aurons le message définit ici
        Assert.assertEquals("La librairie de décryptage est mal installée",keyDecrypted, ManaBox.decrypt(keyCrypted));

    }

    @Test
    public void accentTest(){
        String textAvecAccent="çà cé sônt des aççents inùtilés";
        String textSansAccent= StringUtils.stripAccents(textAvecAccent);

        Assert.assertEquals("ca ce sont des accents inutiles",textSansAccent);
    }


    @Test
    public void createMapTest() {
        String testGermain = "6lUjKOzUj4e/Gelw9c6sDLqHniwulClN6XSayZ+HRF/kbZx+CMf95jxrhm4YFSY26OnxVlsrzGkO00IMeAFs3g==";
        TransCoder transcodeTest = new TransCoder(testGermain);
        Assert.assertNotNull(transcodeTest.getEncode());
        System.out.println(transcodeTest.getEncode().toString());
        Assert.assertNotNull(transcodeTest.getDecode());
        System.out.println(transcodeTest.getDecode().toString());
    }
    @Test
    public void encodeTest(){
        String msg = "Les tests sont la pour essayer !!!";
        TransCoder test=new TransCoder(msg);
        String msgCode=test.encode(msg);
        Assert.assertEquals("BYAPASBNBGAPASBGASBNASAFBHBGBNAHAJBNAZAFBLADBNAPASASAJAMAPADBNBJBJBJ",msgCode);

    }

    @Test
    public void decodeTest(){
        String msg = "BYAPASBNBGAPASBGASBNASAFBHBGBNAHAJBNAZAFBLADBNAPASASAJAMAPADBNBJBJBJ";
        TransCoder test=new TransCoder(msg);
        String msgCode=test.decode(msg);
        Assert.assertEquals("Les tests sont la pour essayer !!!",msgCode);

    }
}
