package solution.task10;

import java.util.Objects;

public class EmailAddress {
    final String address;

    private EmailAddress(String address) {
        this.address = address;
    }

    /**
     * Zaimplementuj metodę, która zwróci obiekt EmailAddress, tylko gdy parametr address jest poprawny
     * jeśli nie to zgłosi wyjątek IllegalArgumentException z komunikatem: address + "is not valid email address!"
     */
    public static EmailAddress of(String address){
        if (isValidAddress(address)){
            throw new IllegalArgumentException("Argument is not a valid email address: " + address);
        }
        return new EmailAddress(address);
    }

    /**
     * Zaimplementuj metodę, która tworzy obiekt EmailAddress na podstawie username i hosta
     * Jeśli nie można zbudowac poprawnego adresu np. gdy w login znajduje się znak '@' lub inny niż alfanumeryczny
     * to zgłosi jeden z dwóch wyjątków:
     *          - IllegalUsernameException, gdy username jest niepoprawnie zbudowany
     *          - IllegalHostException, gdy nazwa host nie niepoprawna
     * Jeśli oba argumenty są błędne to zgłaszamy pierwszy wyjątek
     * Obie klasy wyjątków należy samodzielnie zdefiniować
     */

    public static EmailAddress of(String username, String host) throws IllegalUsernameException, IllegalHostException {
        if (isValidUsername(username)){
            throw new IllegalUsernameException("Username is invalid: " + username);
        }
        if (isValidHost(host)){
            throw  new IllegalHostException("Host is invalid: " + host);
        }
        return new EmailAddress(username + "@" + host);
    }

    public String get(){
         return address;
    }
    public String username(){
        return extractUsername(address);
    }
    public String host(){
        return extractHost(address);
    }
    public String topDomain(){
        return extractTopDomain(address);
    }

    static boolean isValidUsername(String input){
        return !isNull(input) && !isEmpty(input) && !hasOneAtSymbol(input) && hasValidCharacters(input);
    }

    static boolean isValidHost(String input){
        return !isNull(input) && !isEmpty(input) && !hasOneAtSymbol(input) && hasValidCharacters(input) && input.contains(".");
    }

    static boolean isValidAddress(String address){
        return !isNull(address)
                && !isEmpty(address)
                && hasOneAtSymbol(address)
                && hasAtLeastOneDotAfterAtSymbol(address)
                && isValidUsername(extractUsername(address))
                && isValidHost(extractHost(address));
    }

    static  String extractUsername(String address){
        return address.substring(0, address.indexOf('@'));
    }

    static  String extractHost(String address){
        return address.substring(address.indexOf('@') + 1);
    }

    static  String extractTopDomain(String address){
        return address.substring(address.lastIndexOf('.') + 1);
    }

    static  boolean isNull(String input){
        return Objects.isNull(input);
    }

    static  boolean isEmpty(String input){
        return input.isEmpty();
    }

    static  boolean hasOneAtSymbol(String input){
        return input.indexOf('@') == input.lastIndexOf('@') && input.indexOf('@') >= 0;
    }

    static  boolean hasAtLeastOneDotAfterAtSymbol(String input){
        return input.indexOf('@') < input.lastIndexOf('.');
    }

    static  boolean hasValidCharacters(String input){
        String str =  input.replace("@","").replace(".","");
        for(char c: str.toCharArray()){
            if (!Character.isAlphabetic(c)){
                return false;
            }
        }
        return true;
    }
}
