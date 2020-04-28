package Q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormattedList {

    private ListFormatter formatter;
    private List<String> content = new ArrayList<>();

    public FormattedList(ListFormatter formatter, String... items) {
        content.addAll(Arrays.asList(items));
        this.formatter = formatter;
    }

    public void add(String item) {
        content.add(item);
    }

    public void print() {
        System.out.println(formatHeader());
        for (String item : content) {
            System.out.println(formatItem(item));
        }
        System.out.println(formatFooter());
    }

    protected String formatHeader(){
        return formatter.formatHeader();
    };

    protected String formatItem(String item){
        return formatter.formatItem(item);
    };

    protected String formatFooter(){
        return formatter.formatFooter();
    };

}

