package code.wars.catalog;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public class Catalog {

    public static final Pattern PATTERN = Pattern.compile("<name>(?<name>.*)</name>.*<prx>(?<price>.*)</prx>.*<qty>(?<quantity>.*)</qty>");

    public static String catalog(String s, String article) {

        final List<ProductInfo> results = new ArrayList<>();
        final var catalogEntries = s.split("\n\n");
        for (var catalogEntry : catalogEntries) {
            final var matcher = PATTERN.matcher(catalogEntry);
            if (matcher.find()) {
                final var name = matcher.group("name").trim();
                if (name.contains(article)) {
                    final var price = matcher.group("price").trim();
                    final var quantity = matcher.group("quantity").trim();
                    results.add(new ProductInfo(name, price, quantity));
                }
            }
        }

        if (results.isEmpty()) {
            return "Nothing";
        }

        return results.stream()
            .map(Object::toString)
            .collect(joining("\n"));
    }

    public record ProductInfo(String name, String price, String quantity) {

        @Override
        public String toString() {
            return "%s > prx: $%s qty: %s".formatted(name, price, quantity);
        }
    }
}
