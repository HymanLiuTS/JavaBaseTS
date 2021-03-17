package namecheck;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic;

/**
 * @author ：Hyman
 * @date ：Created in 2021/3/17 17:39
 * @description：
 * @modified By：
 * @version: $
 */
public class NameChecker {
    private final Messager messager;

    public NameChecker(ProcessingEnvironment processingEnvironment) {
        this.messager = processingEnvironment.getMessager();
    }

    public class NameCheckScanner extends ElementScanner8 {

        private void checkCamelCase(Element e, boolean initialCaps) {
            String name = e.getSimpleName().toString();
            boolean previousUpper = false;
            boolean conventional = true;
            int firstCodePoint = name.codePointAt(0);
            if (Character.isUpperCase(firstCodePoint)) {
                previousUpper = true;
                if (!initialCaps) {
                    messager.printMessage(Diagnostic.Kind.WARNING, "名称:" + name + "应该以小写字母开头", e);
                    return;
                }
            } else if (Character.isLowerCase(firstCodePoint)) {
                if (initialCaps) {
                    messager.printMessage(Diagnostic.Kind.WARNING, "名称:" + name + "应该以大写字母开头", e);
                    return;
                }
            } else {
                conventional = false;
            }
            //todo
        }

        /**
         * create by: Hyman
         * description:
         * create time: 2021/3/17
         */
        private void checkAllCaps(Element e) {
            String name = e.getSimpleName().toString();
            //todo
        }
    }
}
