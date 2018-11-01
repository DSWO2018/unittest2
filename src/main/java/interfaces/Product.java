package interfaces;

public interface Product  {
        /**
         *get ID.
         * @return         */
        public int getID();

        /**
         *Get price.
         * @return    */
        public double getPrice();

        /**
         *GET description.
         * @return         */
        public String getDescription();

        /**
         *set price.
         * @param price         */
        public void setPrice(double price);

        /**
         *TAXEABLE?.
         * @return         */
        public boolean isTaxeable();

        /**
         * set taxeable.
         * @param         */
        public void setTaxeable(boolean taxable);

        /**
         *get name.
         * @return         */
        public String getName();

        /**
         *set name.
         * @param name         */
        public void setName(String name);

}
