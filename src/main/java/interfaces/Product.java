package interfaces;

/**
 * int prod.
 */
public interface Product  {
        /**
         *get ID.
         * @return         */
         int getID();

        /**
         *Get price.
         * @return    */
         double getPrice();

        /**
         *GET description.
         * @return         */
         String getDescription();

        /**
         *set price.
         * @param price         */
         void setPrice(double price);

        /**
         *TAXEABLE?.
         * @return         */
         boolean isTaxeable();

        /**
         * set taxeable.
         * @param taxable        */
         void setTaxeable(boolean taxable);

        /**
         *get name.
         * @return         */
         String getName();

        /**
         *set name.
         * @param name         */
         void setName(String name);

}
