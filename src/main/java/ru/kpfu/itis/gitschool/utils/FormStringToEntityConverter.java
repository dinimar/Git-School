package ru.kpfu.itis.gitschool.utils;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.util.StringUtils;
import ru.kpfu.itis.gitschool.models.HomeTask;
import ru.kpfu.itis.gitschool.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FormStringToEntityConverter implements GenericConverter {
    private final Class<?> clazz;

    @PersistenceContext
    private EntityManager em;

    public FormStringToEntityConverter(Class<?> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> types = new HashSet<ConvertiblePair>();
        types.add(new ConvertiblePair(String.class, this.clazz));
        return types;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (String.class.equals(sourceType.getType())) {
            if (!StringUtils.hasText((String) source) || ((String) source).equals("NONE")) {
                return null;
            }

            String reqBody = (String) source;

            String name = reqBody.substring(reqBody.indexOf("=") + 1, reqBody.indexOf("&"));
            String homeTaskStr = reqBody.substring(reqBody.lastIndexOf("=") + 1, reqBody.length());

            List<HomeTask> homeTaskList = new ArrayList<>();

            int prIdx = 0;

            while (homeTaskStr.length() != 0) {
                int idx = homeTaskStr.indexOf("&");
                homeTaskList.add(new HomeTask(homeTaskStr.substring(prIdx, idx).replace('+', ' '), ""));
                prIdx = idx + 1;
                homeTaskStr = homeTaskStr.substring(prIdx);
            }

            return new Student(homeTaskList, name);
        } else {
            throw new IllegalArgumentException("Cannot convert " + source + " into a suitable type!");
        }
//
//        } else if (this.clazz.equals(sourceType.getType())) {
//            if (source == null) {
//                return "";
//            } else {
//                try {
//                    Method method = this.clazz.getMethod("getId");
//                    return method.invoke(source, null).toString();
//                } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
//                    throw new IllegalArgumentException("Cannot convert " + source + " into a suitable type: can't call getId method of " + this.clazz.getName() + "!");
//                }
//            }
//        }
//        throw new IllegalArgumentException("Cannot convert " + source + " into a suitable type!");
    }
}
