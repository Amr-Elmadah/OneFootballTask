package onefootball.com.testonefootball;

import org.junit.Test;

import java.util.EnumSet;
import java.util.Set;

import onefootball.com.testonefootball.data.models.PushEventType;
import onefootball.com.testonefootball.data.models.PushRegistrationCategory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PushEventTypeUnitTest {
    @Test
    public void test_isPushOption() {
        PushEventType pushEventType = PushEventType.ALL;
        assertTrue(pushEventType.isPushOption(PushEventType.ALL));
    }

    @Test
    public void test_isNotPushOption() {
        PushEventType pushEventType = PushEventType.ALL;
        assertFalse(pushEventType.isPushOption(PushEventType.FACTS));
    }

    @Test
    public void test_encode() {
        Set<PushEventType> selectedPushOptions = EnumSet.noneOf(PushEventType.class);
        selectedPushOptions.add(PushEventType.ALL);
        assertEquals(PushEventType.encode(selectedPushOptions), -1);
    }

    //Todo :  You can check how decode method calculate its operations (bitwise operations) from here
    // https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Bitwise_Operators

    @Test
    public void test_decodeAllTypes() {
        PushRegistrationCategory pushRegistrationCategory = PushRegistrationCategory.TEAM;
        assertEquals(PushEventType.decode(-1, pushRegistrationCategory), PushEventType.SUPPORTED_TEAM_PUSH_OPTIONS);
    }

    @Test
    public void test_decodeOneType() {
        PushRegistrationCategory pushRegistrationCategory = PushRegistrationCategory.TEAM;
        Set<PushEventType> selectedPushOptions = EnumSet.noneOf(PushEventType.class);
        selectedPushOptions.add(PushEventType.TRANSFER);
        assertEquals(PushEventType.decode(4, pushRegistrationCategory), selectedPushOptions);
    }
}