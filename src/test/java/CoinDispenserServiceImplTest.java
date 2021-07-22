import com.app.model.Coin;
import com.app.model.Dispense;
import com.app.service.CoinDispenserService;
import com.app.service.CoinDispenserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoinDispenserServiceImplTest {

    private CoinDispenserServiceImpl coinDispenserService;

    @Before
    public void init(){

        coinDispenserService = new CoinDispenserServiceImpl();
    }

    @Test
    public void getCoinDenominationsTest(){

        Assert.assertEquals(4, this.coinDispenserService.getCoinDenominations(4).size());
        Assert.assertEquals("V1", this.coinDispenserService.getCoinDenominations(4).get(0).getKey());
        Assert.assertEquals(5, this.coinDispenserService.getCoinDenominations(4).get(2).getValue());
    }

    @Test
    public void dispenseCoinsTest(){

        Dispense dispense = new Dispense();
        dispense.setAmount(10);
        dispense.setCoinDenominations(3);

        Assert.assertEquals(2, this.coinDispenserService.dispenseCoins(dispense).size());
        Assert.assertEquals("V3", this.coinDispenserService.dispenseCoins(dispense).get(0));
        Assert.assertEquals("V3", this.coinDispenserService.dispenseCoins(dispense).get(1));
        Assert.assertNotEquals("V2", this.coinDispenserService.dispenseCoins(dispense).get(1));
    }
}
