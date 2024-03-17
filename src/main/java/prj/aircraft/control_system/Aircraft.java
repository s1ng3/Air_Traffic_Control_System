package prj.aircraft.control_system;

public class Aircraft implements Runnable{
    public String id;
    public int altitude;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Aircraft(int altitude, String id) {
        this.altitude = altitude;
        this.id = id;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public void receiveAtcCommand(AtcCommand cmd) {
        if (cmd instanceof TakeoffCommand)
            this.altitude = ((TakeoffCommand) cmd).altitude;
        else if (cmd instanceof LandCommand) {
        }
    }

    @Override
    public void run() {
        System.out.println("On stand");
        //wait for TAKEOFF_CMD
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Taxing");
        //wait 10 SECONDS
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){}

        System.out.println("Taking off");
        //wait 5 SECONDS
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e) {}
        System.out.println("Ascending");
        int currentAltitude = 0;
        while(currentAltitude<altitude){
            currentAltitude+=1000;
            try{
                Thread.sleep(10000);
            }catch (InterruptedException e){}
        }

        //wait 10 seconds and the altitude increments
        System.out.println("Cruising");
        //waiting for LAND_CMD
        System.out.println("Descending");
        //
        currentAltitude=this.altitude;
        while(currentAltitude!=0)
        {
            currentAltitude-=1000;
            try{
                Thread.sleep(10000);
            }catch (InterruptedException e){}
        }
        System.out.println("Landing");
    }
}
