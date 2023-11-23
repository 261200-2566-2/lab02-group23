import java.util.HashMap;
import java.util.Map;

public class Main {

    public static class AirPurifier {
        String model;
        String brand;
        boolean power;
        int PCADR;
        int FCADR;
        int fanLevel;
        String mode;
        int pmLevel;
        int temperature;
        int humidityPercent;
        double startTime;
        double endTime;

        static int totalModelsManufactured = 0;
        static HashMap<String, Integer> modelCounts = new HashMap<>();//มาจาก chatGPT

        public AirPurifier(String model, String brand, int PCADR, int FCADR) {
            this.model = model;
            this.brand = brand;
            this.PCADR = PCADR;
            this.FCADR = FCADR;
            totalModelsManufactured++;
            modelCounts.put(model, modelCounts.getOrDefault(model, 0) + 1);//มาจาก chatGPT
            this.startTime = 0.0;
            this.endTime = 24.0;
        }

        void turnOn() {
            power = true;
        }

        void turnOff() {
            power = false;
        }

        int setFanLevel(int s) {
            fanLevel = s;
            return fanLevel;
        }

        int getPMLevel() {
            return pmLevel;
        }

        int getTemperature() {
            return temperature;
        }

        int getHumidityPercent() {
            return humidityPercent;
        }

        void setMode(String m) {
            mode = m;
        }

        void setTime(double start, double end) {
            startTime = start;
            endTime = end;
        }

        static String mostPopularModel() {//มาจาก chatGPT
            if (totalModelsManufactured == 0) {
                return "No models manufactured yet.";
            }

            int maxCount = 0;
            int equalCount = 0;
            String popularModel = "";

            for (Map.Entry<String, Integer> entry : modelCounts.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    popularModel = entry.getKey();
                    equalCount = 1;
                } else if (entry.getValue() == maxCount) {
                    equalCount++;
                }
            }

            if (equalCount > 1) {
                return "Multiple models have equal popularity.";
            }


            return popularModel;
        }
    }

    public static class Lab02 {
        public static void main(String[] args) {
            AirPurifier airPurifier1 = new AirPurifier("ModelA", "BrandX", 500, 185);
            airPurifier1.turnOn();
            airPurifier1.setFanLevel(3);
            airPurifier1.setMode("Auto");
            airPurifier1.setTime(8.30, 15.30);

            System.out.println("Air Purifier 1 :");
            System.out.println("Model: " + airPurifier1.model);
            System.out.println("Brand: " + airPurifier1.brand);
            System.out.println("Power: " + airPurifier1.power);
            System.out.println("Fan Level: " + airPurifier1.fanLevel);
            System.out.println("Mode: " + airPurifier1.mode);
            System.out.println("Start Time: " + airPurifier1.startTime);
            System.out.println("End Time: " + airPurifier1.endTime);

            AirPurifier airPurifier2 = new AirPurifier("ModelB", "BrandX", 450, 180);
            airPurifier2.turnOn();
            airPurifier2.setFanLevel(2);
            airPurifier2.setMode("Manual");
            airPurifier2.setTime(10.00, 18.00);

            System.out.println("\nAir Purifier 2 :");
            System.out.println("Model: " + airPurifier2.model);
            System.out.println("Brand: " + airPurifier2.brand);
            System.out.println("Power: " + airPurifier2.power);
            System.out.println("Fan Level: " + airPurifier2.fanLevel);
            System.out.println("Mode: " + airPurifier2.mode);
            System.out.println("Start Time: " + airPurifier2.startTime);
            System.out.println("End Time: " + airPurifier2.endTime);

            AirPurifier airPurifier3 = new AirPurifier("ModelB", "BrandX", 450, 180);
            airPurifier3.turnOn();
            airPurifier3.setFanLevel(1);
            airPurifier3.setMode("Sleep");
            airPurifier3.setTime(9.00, 20.00);

            System.out.println("\nAir Purifier 3 :");
            System.out.println("Model: " + airPurifier3.model);
            System.out.println("Brand: " + airPurifier3.brand);
            System.out.println("Power: " + airPurifier3.power);
            System.out.println("Fan Level: " + airPurifier3.fanLevel);
            System.out.println("Mode: " + airPurifier3.mode);
            System.out.println("Start Time: " + airPurifier3.startTime);
            System.out.println("End Time: " + airPurifier3.endTime);



            System.out.println("\nMost Popular Model: " + AirPurifier.mostPopularModel());
            System.out.println("Total Models Manufactured: " + AirPurifier.totalModelsManufactured);
        }
    }
}
/*
1.give a complete description of AirPurifier class
what should be instance variables?
-
model (String): model ของ air purifier.
brand (String): brand ของ air purifier.
power (boolean): เปิดมั้ย
PCADR (int): กรองอนุภาคกี่ ลูกบาศก์เมตร/ชั่วโมง
FCADR (int): กรองฟอร์มาลดีไฮด์กี่ ลูกบาศก์เมตร/ชั่วโมง
fanLevel (int): เบอร์พัดลม
mode (String): โหมดการทำงานของ Air Purifier
pmLevel (int): ค่า PM
temperature (int): อุณหภูมิในห้อง
humidityPercent (int): ความชื้นในห้อง
startTime (double): เก็บเวลาเริ่มทำงาน
endTime (double): เก็บเวลาเหยุดทำงาน

what should be instance methods?
-
turnOn(): เปิด  Air Purifier
turnOff(): ปิด  Air Purifier
setFanLevel(int s): เลือกระดับความแรงพัดลม
getPMLevel(): แสดงค่า PM
getTemperature(): แสดงระดับอุณหภูมิ
getHumidityPercent(): แสดงค่าความชื้น
setMode(String m): เลือก mode การทำงาน
setTime(double start, double end): ตั้งค่าเวลาเริ่มทำงานกับหยุดทำงาน

what should be class variables?
-
totalModelsManufactured (int): จำนวนที่ผลิตทั้งหมด
modelCounts (HashMap<String, Integer>): จำนวนของแต่ละ model

what should be class methods?
-
mostPopularModel(): air purifier model ที่มากที่สุด





2.for each method proposed above, how do you plan to implement it?
give an overview of the computation
what's needed as inputs?
what's to be returned?
-
turnOn(): set power เป็น true
Input: None
Output: None

turnOff(): set power เป็น false
Input: None
Output: None

setFanLevel(int s): ตั้งค่า fanlevel
Input: ค่า fan level
Output: Update fanlevel

getPMLevel(): return ค่า PM
Input: None
Output: Current PM level

getTemperature(): return temperature
Input: None
Output: Current temperature

getHumidityPercent(): Returns humidity percentage
Input: None
Output: humidity percentage

setMode(String m): set mode
Input: ชื่อ mode
Output: None

setTime(double start, double end): ตั้งค่าช่วงเวลาทำงาน
Input: เวลาเริ่ม กับ เวลาหยุด
Output: None

mostPopularModel(): หา model ที่ popular ที่สุด (วัดจาก count)
Input: None
Output: ชื่อ model ที่ popular ที่สุด


 */