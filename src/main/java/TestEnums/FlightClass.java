package TestEnums;

/**
 * Flight Class Enum.
 */
public enum FlightClass {
        /** Your Account group. **/
        ECONOMY("Economy"),
        PREMIUM_ECONOMY("Premium%20Economy"),
        BUSINESS("Business"),
        FIRST("First");

        /** The value. **/
        private final String value;

        /**
         * Instantiates a new {@link FlightClass}.
         *
         * @param value - the value of the type.
         */
        FlightClass(final String value) {
            this.value = value;
        }

        /**
         * Returns the FlightClass value.
         *
         * @return the value.
         */
        public String getValue() {
            return value;
        }
}
