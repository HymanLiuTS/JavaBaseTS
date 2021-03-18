package namecheck;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic;
import java.util.EnumSet;

/**
 * @author ：Hyman
 * @date ：Created in 2021/3/17 17:39
 * @description：
 * @modified By：
 * @version: $
 */
public class NameChecker {

    private final Messager messager;

    NameCheckScanner nameCheckScanner = new NameCheckScanner();

    public NameChecker(ProcessingEnvironment processingEnvironment) {
        this.messager = processingEnvironment.getMessager();
    }

    public void checkName(Element element) {
        nameCheckScanner.scan(element);
    }

    public class NameCheckScanner extends ElementScanner8 {

        /**
         * create by: Hyman
         * description: 检查java类是否合法
         * create time: 2021/3/18
         */
        public Void visitType(TypeElement e, Void p) {
            scan(e.getEnclosedElements(), p);
            checkCamelCase(e, true);
            super.visitType(e, p);
            return null;
        }

        /**
         * create by: Hyman
         * description: 检查方法命名是否合法
         * create time: 2021/3/18
         */
        public Void visitVariable(VariableElement e, Void p) {
            if (e.getKind() == ElementKind.METHOD) {
                Name name = e.getSimpleName();
                if (name.contentEquals(e.getEnclosingElement().getSimpleName())) {
                    messager.printMessage(Diagnostic.Kind.WARNING, "一个普通方法：" + name + "，不应当与类名重复", e);
                    checkCamelCase(e, false);
                }
            }
            super.visitVariable(e, p);
            return null;
        }

        /**
         * create by: Hyman
         * description: 检查变量命名是否合法
         * create time: 2021/3/18
         */
        public Void visitExecutable(VariableElement e, Void p) {
            if (e.getKind() == ElementKind.ENUM_CONSTANT ||
                    e.getConstantValue() != null) {
                checkAllCaps(e);
            } else {
                checkCamelCase(e, false);
            }
            return null;
        }

        /**
         * create by: Hyman
         * description: 判断一个变量是不是常量
         * create time: 2021/3/18
         */
        private boolean heuristcallyConstant(VariableElement e) {
            if (e.getEnclosingElement().getKind() == ElementKind.INTERFACE) {
                return true;
            } else if (e.getKind() == ElementKind.FIELD &&
                    e.getModifiers().containsAll(EnumSet.of(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL))) {
                return true;
            }
            return false;
        }

        /**
         * create by: Hyman
         * description: 检查传入的Element是否符合驼峰命名
         * create time: 2021/3/18
         */
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
         * description: 大写命名检查，要求第一个字母必须是大写字母
         * create time: 2021/3/17
         */
        private void checkAllCaps(Element e) {
            String name = e.getSimpleName().toString();
            //todo
        }


    }
}
