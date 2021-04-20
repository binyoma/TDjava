package tools;

import org.germain.tool.ManaBox;
import org.junit.Assert;
import org.junit.Test;

public class TransCoder {
    private  String msg;



    public TransCoder(String msg) {
        this.msg = msg;
    }

    public String getEncode() {
        return ManaBox.encrypt(this.msg);
    }

    public String getDecode() {
        return ManaBox.decrypt(this.msg);
    }

    public String getMsg() {
        return msg;
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


}
