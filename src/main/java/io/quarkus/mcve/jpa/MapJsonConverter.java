package io.quarkus.mcve.jpa;

import io.vertx.core.json.JsonObject;
import javax.persistence.AttributeConverter;
import java.util.Map;

/**
 * In Hibernate Reactive, AttributeConverter is pointed as the preferable solution
 *  to handle custom db serialization.
 * -> Source: http://hibernate.org/reactive/documentation/1.0/reference/html_single/#_custom_types
 *
 * This issue from Quarkus repository pointed me to this direction:
 *   -> https://github.com/hibernate/hibernate-reactive/issues/279
 *
 * Jackson already handle OK the serialization from attribute which is a Map,
 * and the Postgres Reactive Driver already know how to pass JsonObject to the
 * jsonb and json column types, so the solution is very simple and does not
 * require another dependencies
 */
public class MapJsonConverter implements AttributeConverter<Map, JsonObject> {

    @Override
    public JsonObject convertToDatabaseColumn(Map map) {
        return new JsonObject(map);
    }

    @Override
    public Map convertToEntityAttribute(JsonObject jsonObject) {
        return jsonObject.getMap();
    }
}
