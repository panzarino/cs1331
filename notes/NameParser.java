/**
 * NameParser takes a single String-valued command line argument of
 * the form "last_name, first_name" and prints the first and last names
 * separately.
 */
public class NameParser {

    public static String extractLastName(String name) {
        int commaPos = name.indexOf(",");
        String lastName = name.substring(0, commaPos).trim();
        return lastName;
    }

    public static String extractFirstName(String name) {
        int commaPos = name.indexOf(",");
        int len = name.length();
        String firstName = name.substring(commaPos + 1, len).trim();
        return firstName;
    }

    public static String getInitials(String name) {
        name = name.replaceAll("\\s+", "");
        return name.charAt(name.indexOf(",") + 1) + "." + name.charAt(0) + ".";
    }

    public static void main(String[] args) {
        String fullName = args[0];
        String lastName = extractLastName(fullName);
        String firstName = extractFirstName(fullName);
        String initials = getInitials(fullName);
        System.out.println("First name:\t" + firstName);
        System.out.println("Last name:\t" + lastName);
        System.out.println("Initials:\t" + initials);
    }

}
