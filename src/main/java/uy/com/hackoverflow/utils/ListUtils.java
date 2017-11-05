package uy.com.hackoverflow.utils;

import uy.com.hackoverflow.models.Workshop;

import java.util.List;

/**
 * Created by emiliano on  04/11/17.
 */
public class ListUtils {

    public static boolean userEnrollmentInWorkshop(List<Workshop> workshops, Long workshopId) {
        for (Workshop w : workshops) {
            if(w.getId().equals(workshopId)){
                return true;
            }
        }
        return false;
    }
}
