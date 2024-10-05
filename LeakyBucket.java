import java.util.Scanner;

class LeakyBucket {

    private int bucketCapacity;
    private int leakRate;
    private int currentWater;
    public LeakyBucket(int bucketCapacity, int leakRate) {
        this.bucketCapacity = bucketCapacity;
        this.leakRate = leakRate;
        this.currentWater = 0;
    }
    public void addPackets(int incomingPackets, int time) {
        System.out.println("\nTime unit: " + time);
        System.out.println("Incoming packets: " + incomingPackets);
        if (incomingPackets <= bucketCapacity - currentWater) {
            currentWater += incomingPackets;
            System.out.println("Packets added to bucket. Current water level: " + currentWater + " packets");
        } else {
            System.out.println("Bucket overflow! Packets lost: " + (incomingPackets - (bucketCapacity - currentWater)));
            currentWater = bucketCapacity;
        }
        transmitPackets();
    }
    public void transmitPackets() {
        if (currentWater <= leakRate) {
            System.out.println("All " + currentWater + " packets transmitted.");
            currentWater = 0;
        } else {
            System.out.println(leakRate + " packets transmitted.");
            currentWater -= leakRate;
        }
        System.out.println("Current water level after transmission: " + currentWater + " packets\n");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the bucket capacity (packets): ");
        int bucketCapacity = sc.nextInt();
        System.out.print("Enter the leak rate (packets per time unit): ");
        int leakRate = sc.nextInt();
        LeakyBucket lb = new LeakyBucket(bucketCapacity, leakRate);
        for (int time = 1; time <= 5; time++) {
            System.out.print("\nEnter the number of incoming packets at time unit " + time + ": ");
            int incomingPackets = sc.nextInt();
            lb.addPackets(incomingPackets, time);
        }
        System.out.println("Processing remaining packets...");
        while (lb.currentWater > 0) {
            lb.transmitPackets();
        }
        System.out.println("No more packets in the bucket.");
        sc.close();
    }
}
