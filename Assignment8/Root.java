class Device {
    public void startup() {
        System.out.println("Device starting");
    } // print to console that device is starting
    public void shutdown() {
        System.out.println("Device shutting down");
    } // print to console that device is shutting down and exit
}

class Sensor extends Thread {
    private final Device device;
    private double value;
    public Sensor(Device device) {
        this.device = device;
    }
    public double getValue() {
        return value;
    }
    public void updateValue() {
        this.value += 0.001; // you check with other values here and see how it works
    }
    public void run() {
        while(true) {
            synchronized (device) {
                this.updateValue();
                device.notify();
            }
        }
    }
}

class Controller extends Thread {
    Device device;
    Sensor heat;
    Sensor pressure;
    public Controller(Device device, Sensor heat, Sensor pressure) {
        this.device = device;
        this.heat = heat;
        this.pressure = pressure;
    }

    public void run() {
        device.startup();
        while(true) {
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            System.out.println("heat -> " + heat.getValue() + ", pressure -> " + pressure.getValue());
            if (heat.getValue() > 70 || pressure.getValue() > 100) {
                device.shutdown();
                break;
            }
        }
    }
}

public class Root {

    public static void main(String[] args) {

        Device device = new Device();
        Sensor heat = new Sensor(device);
        Sensor pressure = new Sensor(device);

        Controller controller = new Controller(device,heat,pressure);

        controller.start();
        heat.start();
        pressure.start();
    }

}
