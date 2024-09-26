package exercise3;

import java.util.Arrays;

public class Friends {
    private final String[] friends = {
            "Name is Mina and from Hong Kong and doesn't have a cat and doesn't have an iPhone",
            "Name is Winter and from Hong Kong and has an airplane and has a cat and has an iPhone",
            "Name is Yoonji and from Hong Kong and has a cat and also has an airplane and has an iPhone",
            "Name is Stephen and from Hong Kong and has a cat and has an iPhone",
    };

    public String[] getFriends(String country) {
        return Arrays.stream(friends)
                .filter(friend -> friend.contains("from " + country))
                .toArray(String[]::new);
    }

    public String[] getFriends(String country, String pet) {
        return Arrays.stream(friends)
                .filter(friend -> friend.contains("from " + country) && friend.contains("has " + pet))
                .toArray(String[]::new);
    }

    public String[] getFriends(String country, String pet, String belonging) {
        return Arrays.stream(friends)
                .filter(friend -> friend.contains("from " + country) &&
                        friend.contains("has " + pet) &&
                        friend.contains("has " + belonging))
                .toArray(String[]::new);
    }

    public String[] getFriends(String country, String pet, String belonging, boolean hasIPhone) {
        return Arrays.stream(friends)
                .filter(friend -> friend.contains("from " + country) &&
                        friend.contains("has " + pet) && friend.contains("has " + belonging) &&
                        friend.contains(hasIPhone ? "has an iPhone" : "doesn't have an iPhone")
                )
                .toArray(String[]::new);
    }
}
