package namecheck;

import javax.lang.model.element.Element;
import javax.lang.model.util.ElementScanner8;

/**
 * @author ：Hyman
 * @date ：Created in 2021/3/17 17:41
 * @description：
 * @modified By：
 * @version: $
 */
public class NameCheckScanner extends ElementScanner8 {


    private void checkCamelCase(Element e, boolean initialCaps) {
        String name = e.getSimpleName().toString();
        boolean previousUpper = false;
        boolean conventional = true;
        int firstCodePoint = name.codePointAt(0);
        if (Character.isUpperCase(firstCodePoint)) {
            previousUpper = true;
            if(!initialCaps){

            }
        }
    }
}
