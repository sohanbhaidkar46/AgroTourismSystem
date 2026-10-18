import java.util.Scanner;

/**
 * AgroTourismSystem demonstrates all forms of OOP Inheritance in Java
 * applied to an integrated Agriculture and Tourism management platform.
 *
 * @author Student Name
 * @version 1.0
 */
public class AgroTourismSystem {

    // =========================================================================
    // 1. SINGLE INHERITANCE: Farm -> OrganicFarm
    // =========================================================================

    /**
     * Represents a general agricultural farm.
     */
    static class Farm {
        protected String farmName;
        protected double areaInAcres;

        /**
         * Parameterized constructor for Farm.
         * @param farmName Name of the farm
         * @param areaInAcres Total land size in acres
         */
        public Farm(String farmName, double areaInAcres) {
            this.farmName = farmName;
            this.areaInAcres = areaInAcres;
        }

        /**
         * Displays basic farm details.
         */
        public void displayFarmDetails() {
            System.out.println("Farm Name: " + farmName);
            System.out.println("Total Area: " + areaInAcres + " Acres");
        }
    }

    /**
     * Represents an Organic Farm (Child class extending Farm).
     */
    static class OrganicFarm extends Farm {
        private String certificationBody;

        /**
         * Parameterized constructor for OrganicFarm.
         * @param farmName Name of the farm
         * @param areaInAcres Total land size in acres
         * @param certificationBody Organic certification authority
         */
        public OrganicFarm(String farmName, double areaInAcres, String certificationBody) {
            super(farmName, areaInAcres);
            this.certificationBody = certificationBody;
        }

        /**
         * Displays organic farm certification and details.
         */
        public void displayOrganicDetails() {
            displayFarmDetails();
            System.out.println("Certification: " + certificationBody);
            System.out.println("Type: 100% Chemical-Free Bio-Farming");
        }
    }

    // =========================================================================
    // 2. MULTILEVEL INHERITANCE: AgroEntity -> TourSpot -> FarmStayTour
    // =========================================================================

    /**
     * Root entity representing an identity in the agro-tourism domain.
     */
    static class AgroEntity {
        protected String registrationId;

        public AgroEntity(String registrationId) {
            this.registrationId = registrationId;
        }

        public void showId() {
            System.out.println("Registry ID: " + registrationId);
        }
    }

    /**
     * Represents a designated tourism spot (derived from AgroEntity).
     */
    static class TourSpot extends AgroEntity {
        protected String spotLocation;

        public TourSpot(String registrationId, String spotLocation) {
            super(registrationId);
            this.spotLocation = spotLocation;
        }

        public void showLocation() {
            showId();
            System.out.println("Spot Location: " + spotLocation);
        }
    }

    /**
     * Represents a stay package at a farm (derived from TourSpot).
     */
    static class FarmStayTour extends TourSpot {
        private double pricePerNight;
        private int stayDurationDays;

        public FarmStayTour(String registrationId, String spotLocation, double pricePerNight, int stayDurationDays) {
            super(registrationId, spotLocation);
            this.pricePerNight = pricePerNight;
            this.stayDurationDays = stayDurationDays;
        }

        public void displayStayPackage() {
            showLocation();
            System.out.println("Stay Duration: " + stayDurationDays + " days");
            System.out.println("Package Total: INR " + (pricePerNight * stayDurationDays));
        }
    }

    // =========================================================================
    // 3. HIERARCHICAL INHERITANCE: Crop -> FoodCrop, CashCrop
    // =========================================================================

    /**
     * Base class for agricultural crops.
     */
    static class Crop {
        protected String cropName;
        protected String season;

        public Crop(String cropName, String season) {
            this.cropName = cropName;
            this.season = season;
        }

        public void displayCropInfo() {
            System.out.println("Crop Name: " + cropName + " | Season: " + season);
        }
    }

    /**
     * Represents a staple food crop cultivated for tourist consumption and supply.
     */
    static class FoodCrop extends Crop {
        private double caloriePer100g;

        public FoodCrop(String cropName, String season, double caloriePer100g) {
            super(cropName, season);
            this.caloriePer100g = caloriePer100g;
        }

        public void displayFoodDetails() {
            displayCropInfo();
            System.out.println("Nutritional Value: " + caloriePer100g + " kcal/100g");
        }
    }

    /**
     * Represents a commercial cash crop featured in estate agro-tours (e.g., Tea/Coffee).
     */
    static class CashCrop extends Crop {
        private double marketPricePerQuintal;

        public CashCrop(String cropName, String season, double marketPricePerQuintal) {
            super(cropName, season);
            this.marketPricePerQuintal = marketPricePerQuintal;
        }

        public void displayCashCropDetails() {
            displayCropInfo();
            System.out.println("Market Rate: INR " + marketPricePerQuintal + " per Quintal");
        }
    }

    // =========================================================================
    // 4. MULTIPLE INHERITANCE (via Interfaces)
    // =========================================================================

    /**
     * Interface defining agricultural activities tourists can participate in.
     */
    interface FarmActivity {
        void conductHarvestingWorkshop();
    }

    /**
     * Interface defining tourist guide and hospitality amenities.
     */
    interface TourismService {
        void provideGuidedTour();
    }

    /**
     * Class implementing multiple inheritance using interfaces.
     */
    static class AgroTourPackage implements FarmActivity, TourismService {
        private String packageName;

        public AgroTourPackage(String packageName) {
            this.packageName = packageName;
        }

        @Override
        public void conductHarvestingWorkshop() {
            System.out.println("[Agri-Module] Hands-on organic strawberry picking and compost preparation.");
        }

        @Override
        public void provideGuidedTour() {
            System.out.println("[Tourism-Module] 3-hour bilingual guided vineyard and greenhouse walk.");
        }

        public void printSummary() {
            System.out.println("Package Name: " + packageName);
            conductHarvestingWorkshop();
            provideGuidedTour();
        }
    }

    // =========================================================================
    // 5. HYBRID INHERITANCE: AgroEntity + FarmActivity + HospitalityService -> AgroResort
    // =========================================================================

    /**
     * Interface defining lodging and dining services.
     */
    interface HospitalityService {
        void bookLodging();
    }

    /**
     * AgroResort demonstrates Hybrid Inheritance by extending AgroEntity 
     * and implementing FarmActivity and HospitalityService.
     */
    static class AgroResort extends AgroEntity implements FarmActivity, HospitalityService {
        private String resortName;

        public AgroResort(String registrationId, String resortName) {
            super(registrationId);
            this.resortName = resortName;
        }

        @Override
        public void conductHarvestingWorkshop() {
            System.out.println("[Agri Action] Hydroponic seed cultivation demonstration for visitors.");
        }

        @Override
        public void bookLodging() {
            System.out.println("[Hospitality Action] Eco-cottage booked with farm-to-table organic dining.");
        }

        public void displayResortProfile() {
            System.out.println("Resort: " + resortName);
            showId();
            conductHarvestingWorkshop();
            bookLodging();
        }
    }

    // =========================================================================
    // MENU-DRIVEN CONTROLLER
    // =========================================================================

    /**
     * Main entry point to run the interactive menu.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========================================================");
            System.out.println("       AGRO-TOURISM INHERITANCE MANAGEMENT SYSTEM       ");
            System.out.println("========================================================");
            System.out.println("1. Single Inheritance (Farm -> OrganicFarm)");
            System.out.println("2. Multilevel Inheritance (AgroEntity -> TourSpot -> FarmStayTour)");
            System.out.println("3. Hierarchical Inheritance (Crop -> FoodCrop & CashCrop)");
            System.out.println("4. Multiple Inheritance via Interfaces (AgroTourPackage)");
            System.out.println("5. Hybrid Inheritance (AgroEntity + Interfaces -> AgroResort)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number between 1 and 6: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            System.out.println("--------------------------------------------------------");

            switch (choice) {
                case 1:
                    System.out.println("--- [SINGLE INHERITANCE] ---");
                    OrganicFarm orgFarm = new OrganicFarm("Green Valley Agro Estate", 25.5, "India Organic / NPOP Certified");
                    orgFarm.displayOrganicDetails();
                    break;

                case 2:
                    System.out.println("--- [MULTILEVEL INHERITANCE] ---");
                    FarmStayTour tour = new FarmStayTour("REG-AG-2026-99", "Coorg Spice Plantation, Karnataka", 2200.0, 3);
                    tour.displayStayPackage();
                    break;

                case 3:
                    System.out.println("--- [HIERARCHICAL INHERITANCE] ---");
                    System.out.println("[Branch A - Food Crop]:");
                    FoodCrop wheat = new FoodCrop("Durum Wheat", "Rabi", 340.0);
                    wheat.displayFoodDetails();

                    System.out.println("\n[Branch B - Cash Crop]:");
                    CashCrop coffee = new CashCrop("Arabica Coffee Bean", "Monsoon/Winter", 32000.0);
                    coffee.displayCashCropDetails();
                    break;

                case 4:
                    System.out.println("--- [MULTIPLE INHERITANCE VIA INTERFACES] ---");
                    AgroTourPackage tourPackage = new AgroTourPackage("Weekend Agro-Experience Pass");
                    tourPackage.printSummary();
                    break;

                case 5:
                    System.out.println("--- [HYBRID INHERITANCE] ---");
                    AgroResort resort = new AgroResort("RESORT-IND-88", "Wildwood Eco Farm Resort");
                    resort.displayResortProfile();
                    break;

                case 6:
                    System.out.println("Exiting Agro-Tourism System. Happy Farming and Traveling!");
                    break;

                default:
                    System.out.println("Invalid option! Please select from 1 to 6.");
            }
        } while (choice != 6);

        scanner.close();
    }
}