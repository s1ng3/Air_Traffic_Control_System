package prj.aircraft.control_system;


public class AtcCommand {
}

class TakeoffCommand extends AtcCommand {
    public int altitude;

    public TakeoffCommand(int altitude) {
        this.altitude = altitude;
    }

}

class LandCommand extends AtcCommand {
    public int altitude;
    public LandCommand(int altitude){
        this.altitude=altitude;
    }
}
