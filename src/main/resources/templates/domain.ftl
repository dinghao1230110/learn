package ${groupId}.${packageName};

public class ${className} {
    private ${fieldType} ${fieldName};

    public void set${fieldName?cap_first}(${fieldType} ${fieldName}) {
        this.${fieldName} = ${fieldName};
    }

    public void get${fieldName?cap_first}() {
        return ${fieldName};
    }
}