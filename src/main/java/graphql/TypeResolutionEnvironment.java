package graphql;

import graphql.language.Field;
import graphql.schema.GraphQLSchema;
import graphql.schema.GraphQLType;

import java.util.Map;

/**
 * This is passed to a {@link graphql.schema.TypeResolver} to help with object type resolution.
 *
 * See {@link graphql.schema.TypeResolver#getType(TypeResolutionEnvironment)} for how this is used
 */
public class TypeResolutionEnvironment {

    private final Object object;
    private final Map<String, Object> arguments;
    private final Field field;
    private final GraphQLType fieldType;
    private final GraphQLSchema schema;

    public TypeResolutionEnvironment(Object object, Map<String, Object> arguments, Field field, GraphQLType fieldType, GraphQLSchema schema) {
        this.object = object;
        this.arguments = arguments;
        this.field = field;
        this.fieldType = fieldType;
        this.schema = schema;
    }

    /**
     * @return the object that needs to be resolved into a specific graphql type
     */
    public Object getObject() {
        return object;
    }

    /**
     * @return the runtime arguments to this the graphql field
     */
    public Map<String, Object> getArguments() {
        return arguments;
    }

    /**
     * @return the graphql field in question
     */
    public Field getField() {
        return field;
    }

    /**
     * @return the type of the graphql field, which still be either a {@link graphql.schema.GraphQLUnionType} or a
     * {@link graphql.schema.GraphQLInterfaceType}
     */
    public GraphQLType getFieldType() {
        return fieldType;
    }

    /**
     * @return the graphql schema in question
     */
    public GraphQLSchema getSchema() {
        return schema;
    }
}
