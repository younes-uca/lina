package ma.zs.stocky.integration.core.commun.categorie-client;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class CategorieClientIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("CategorieClientHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
