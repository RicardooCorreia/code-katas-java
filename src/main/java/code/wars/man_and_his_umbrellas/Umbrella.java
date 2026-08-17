package code.wars.man_and_his_umbrellas;

public class Umbrella {

    public static int minUmbrellas(Weather... forecast) {

        final UmbrellaTracker umbrellaTracker = new UmbrellaTracker();
        Location currentLocation = Location.HOME;
        for (var weather : forecast) {
            currentLocation = umbrellaTracker.travel(currentLocation, weather);
        }
        return umbrellaTracker.newUmbrellas();
    }

    public static class UmbrellaTracker {

        private int umbrellaAtHome = 0;
        private int umbrellaAtWork = 0;
        private int newUmbrellas = 0;

        public Location travel(Location location, Weather weather) {
            return switch (location) {
                case HOME -> {
                    if (isRainy(weather)) {
                        if (umbrellaAtHome == 0) {
                            newUmbrellas++;
                        } else {
                            umbrellaAtHome--;
                        }
                        umbrellaAtWork++;
                    }
                    yield Location.WORK;
                }
                case WORK -> {
                    if (isRainy(weather)) {
                        if (umbrellaAtWork == 0) {
                            newUmbrellas++;
                        } else {
                            umbrellaAtWork--;
                        }
                        umbrellaAtHome++;
                    }
                    yield Location.HOME;
                }
            };
        }

        public int newUmbrellas() {
            return newUmbrellas;
        }
    }

    public static boolean isRainy(Weather weather) {
        return switch (weather) {
            case RAINY, THUNDERSTORMS -> true;
            default -> false;
        };
    }

    public enum Weather {
        CLEAR, SUNNY, CLOUDY, RAINY, OVERCAST, WINDY, THUNDERSTORMS;

    }

    public enum Location {
        HOME, WORK;
    }
}


