package homework.task10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailAddressTest {

    @Test
    void of() {
        assertEquals("aa@op.pl", EmailAddress.of("aa@op.pl").get());
        assertEquals("aa.aa@op.pl", EmailAddress.of("aa.aa@op.pl").get());
        assertEquals("AA@ss.edu.pl", EmailAddress.of("AA@ss.edu.pl").get());

        assertThrows(IllegalArgumentException.class, () -> EmailAddress.of("aa@aa@op.pl"));
        assertThrows(IllegalArgumentException.class, () -> EmailAddress.of("aa1@aa@op.pl"));
        assertThrows(IllegalArgumentException.class, () -> EmailAddress.of(""));
        assertThrows(IllegalArgumentException.class, () -> EmailAddress.of("aa.op.pl"));
        assertThrows(IllegalArgumentException.class, () -> EmailAddress.of("aa@sda12.op.pl"));
        assertThrows(IllegalArgumentException.class, () -> EmailAddress.of("@sda12.op.pl"));
        assertThrows(IllegalArgumentException.class, () -> EmailAddress.of("@aas"));
        assertThrows(IllegalArgumentException.class, () -> EmailAddress.of("aBC@aaass.1"));
    }

    @Test
    void from() {
        assertEquals("aa@op.pl", EmailAddress.of("aa", "op.pl").get());

//        assertThrows(IllegalUsernameException.class, () -> EmailAddress.of("", "@op.pl"));
//        assertThrows(IllegalUsernameException.class, () -> EmailAddress.of(null, "@op.pl"));
//        assertThrows(IllegalUsernameException.class, () -> EmailAddress.of("as@kl", "@op.pl"));
//        assertThrows(IllegalUsernameException.class, () -> EmailAddress.of("12as", "@op.pl"));
//
//        assertThrows(IllegalHostException.class, () -> EmailAddress.of("aaa.oa", "op"));
//        assertThrows(IllegalHostException.class, () -> EmailAddress.of("aaa", "op"));
//        assertThrows(IllegalHostException.class, () -> EmailAddress.of("aaa", "op.p1"));
//        assertThrows(IllegalHostException.class, () -> EmailAddress.of("aaa", "op.p1"));
//        assertThrows(IllegalHostException.class, () -> EmailAddress.of("aaa", null));
//        assertThrows(IllegalHostException.class, () -> EmailAddress.of("aaa", ""));

    }

    @Test
    void get() {
        assertEquals("aa@op.pl", EmailAddress.of("aa@op.pl").get());
    }

    @Test
    void username() {
        assertEquals("aa", EmailAddress.of("aa@op.pl").username());
    }

    @Test
    void host() {
        assertEquals("op.pl", EmailAddress.of("aa@op.pl").host());
    }

    @Test
    void topDomain() {
        assertEquals("pl", EmailAddress.of("aa@op.pl").topDomain());
    }
}