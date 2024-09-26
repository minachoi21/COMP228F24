package exercise3;

public class Main {
    public static void main(String[] args) {
        Friends friendsList = new Friends();

        // Test getFriends method by country
        System.out.println("Friends from Hong Kong:\n" + String.join("\n", friendsList.getFriends("Hong Kong")));

        // Test getFriends method by country and pet
        System.out.println("Friends from Hong Kong with a cat:\n" + String.join("\n", friendsList.getFriends("Hong Kong", "a cat")));

        // Test getFriends method by country, cat, and airplane
        System.out.println("Friends from Hong Kong with a cat and an airplane:\n" +
                String.join("\n", friendsList.getFriends("Hong Kong", "a cat", "an airplane")));

        // Test getFriends method by country, cat, belonging, and iPhone
        System.out.println("Friends from Hong Kong with a cat and an airplane and an iPhone:\n" +
                String.join("\n", friendsList.getFriends("Hong Kong", "a cat", "an airplane", true)));
    }
}
