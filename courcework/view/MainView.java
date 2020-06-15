package view;

import model.Teacher;
import view.handlerresource.ResouceLangContainer;
import view.handlerresource.ResourceBundleWords;

import java.util.Arrays;
import java.util.Locale;

public class MainView {

    private ResouceLangContainer resouceLangContainer;

    public MainView() {
        resouceLangContainer = new ResouceLangContainer();
    }

    public void print(String message) {
        System.out.println();
        String value = resouceLangContainer.getValueByKey(message);
        System.out.println(value);
    }

    public void printErr(String err) {
        String value = resouceLangContainer.getValueByKey(err);
        System.err.println(value);
    }


    public void printTeachers(Teacher[] teachers) {
        if (teachers.length == 0) {
            print(ResourceBundleWords.TEACHERS_NOT_FOUNDED);
            return;
        }
        String systemOutParametr = "%-13.13s%-13.13s%-15.15s%-13.13s%-40.40s%-13.13s%-17.17s%n";
        System.out.printf(systemOutParametr,
                resouceLangContainer.getValueByKey(ResourceBundleWords.NAME),
                resouceLangContainer.getValueByKey(ResourceBundleWords.SURNAME),
                resouceLangContainer.getValueByKey(ResourceBundleWords.THIRD_NAME),
                resouceLangContainer.getValueByKey(ResourceBundleWords.GENDER),
                resouceLangContainer.getValueByKey(ResourceBundleWords.DISCIPLINES),
                resouceLangContainer.getValueByKey(ResourceBundleWords.DEPARTMENT),
                resouceLangContainer.getValueByKey(ResourceBundleWords.RANK));
        System.out.printf(systemOutParametr, "____", "_______", "_________", "_______", "____________", "____________", "____");
        for (int itter = 0; itter < teachers.length; itter++) {
            System.out.printf(systemOutParametr,
                    teachers[itter].getName(),
                    teachers[itter].getSurname(),
                    teachers[itter].getThirdName(),
                    teachers[itter].getGender(),
                    Arrays.toString(teachers[itter].getDisciplines()),
                    teachers[itter].getDepartment(),
                    teachers[itter].getRank());
        }
    }

    public ResouceLangContainer getResouceLangContainer() {
        return resouceLangContainer;
    }

    public void setLocaleAndRes(Locale localeAndRes) {
        this.resouceLangContainer.changeLocaleAndBundle(localeAndRes);
    }


}
