package utils;

import org.testng.Assert;
import java.util.List;


public class AssertionUtils {

    public static void assertListContainsSubstring(List<String> list, String substring) {
        boolean found = list.stream().anyMatch(text -> text.contains(substring));
        Assert.assertTrue(found,
                "Expected one of the items to contain '"
                        + substring + "' but got: " + list);
    }

}
