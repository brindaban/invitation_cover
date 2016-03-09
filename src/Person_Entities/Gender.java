package Person_Entities;

public enum Gender {
    MALE {
        @Override
        public String toString() {
            return "Mr";
        }
    },
    FEMALE {
        @Override
        public String toString() {
            return "Ms";
        }
    }
}
