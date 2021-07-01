package TestEnums;

/**
 * Passenger Type Enum.
 */
public enum PassengerType {
        /** Your Account group. **/
        ADULT("Adult"),
        CHILD("Child"),
        INFANT("Infant");

        /** The value. **/
        private final String value;

        /**
         * Instantiates a new {@link PassengerType}.
         *
         * @param value - the value of the type.
         */
        PassengerType(final String value) {
            this.value = value;
        }

        /**
         * Returns the PassengerType value.
         *
         * @return the value.
         */
        public String getValue() {
            return value;
        }
}
