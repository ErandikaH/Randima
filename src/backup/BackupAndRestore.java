/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author PC
 */
public class BackupAndRestore {

    public static boolean backupDB(String dbName, String dbUserName, String dbPassword, String path) {

        String executeCmd = "mysqldump -u " + dbUserName + " -p" + dbPassword + " --add-drop-database -B " + dbName + " -r " + path;
        Process runtimeProcess;
        try {
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                System.out.println("Backup created successfully");
                return true;
            } else {
                System.out.println("Could not create the backup");
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
        }

        return false;
    }

    //
    public boolean restoreDB(String dbUserName, String dbPassword, String source) {

        String[] executeCmd = new String[]{"mysql", "--user=" + dbUserName, "--password=" + dbPassword, "-e", "source " + source};
        //System.out.println(executeCmd);

        Process runtimeProcess;
        try {

            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                System.out.println("Backup restored successfully");
                return true;
            } else {
                System.out.println("Could not restore the backup");
            }
            InputStreamReader inputStreamReader = new InputStreamReader(runtimeProcess.getErrorStream());

            BufferedReader br = new BufferedReader(inputStreamReader);

            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception ex) {
            //ex.printStackTrace();
        }

        return false;
    }
}
