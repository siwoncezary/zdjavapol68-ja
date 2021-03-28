package solution.task14.abook.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressItemTest {

    @Test
    void isEmailAddressValid() {
        assertTrue(AddressItem.isEmailAddressValid("karol@op.pl"));
        assertFalse(AddressItem.isEmailAddressValid("aaa@op.pl@pl"));
        assertFalse(AddressItem.isEmailAddressValid("aaa@op"));
        assertFalse(AddressItem.isEmailAddressValid("aaa"));
    }
}