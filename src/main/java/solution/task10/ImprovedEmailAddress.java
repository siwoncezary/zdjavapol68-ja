package solution.task10;

public class ImprovedEmailAddress{

    public static EmailAddress of(String address){
        if (isValidUserName(address)){
            return EmailAddress.of(address);
        } else {
            throw new IllegalArgumentException("Invalid email address");
        }
    }


    static boolean isValidAddress(String input){
        String username = EmailAddress.extractUsername(input);
        String host = EmailAddress.extractHost(input);
        return isValidUserName(username) && isValidHost(host);
    }

    static boolean isValidHost(String input){
        return false;
    }

    static boolean isValidUserName(String username){
        return !EmailAddress.isNull(username) && !EmailAddress.isEmpty(username) && !hasFirstDigit(username) && hasLettersOrDigits(username);
    }

    static boolean hasLettersOrDigits(String input){
        for(char c: input.toCharArray()){
            if (!Character.isLetterOrDigit(c)){
                return false;
            }
        }
        return true;
    }

    static boolean hasFirstDigit(String input){
        return Character.isDigit(input.charAt(0));
    }

    static boolean hasLetters(String input){
        for(char c: input.toCharArray()){
            if (!Character.isAlphabetic(c)){
                return false;
            }
        }
        return true;
    }

}
