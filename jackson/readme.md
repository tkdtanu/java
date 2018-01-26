<b>JSON Manipulation With Jackson</b><br>
-------------------------------<br>

<b>Serialization Annotaions</b><br>
@JsonAnyGetter annotation allows the flexibility of using a Map field as standard properties<br><br>

@JsonGetter annotation is an alternative to the @JsonProperty annotation to mark the specified method as a getter method.<br><br>

@JsonPropertyOrder annotation is used to specify the order of properties on serialization<br><br>

@JsonRawValue is used to instruct the Jackson to serialize a property exactly as is.<br><br>

@JsonValue indicates a single method that should be used to serialize the entire instance.<br><br>

@JsonRootName annotation is used – if wrapping is enabled – to specify the name of the root wrapper to be used.<br><br>

@JsonSerialize is used to indicate a custom serializer will be used to marshall the entity.<br><br>

<b>Deserialization Annotations</b><br>
The @JsonCreator annotation is used to tune the constructor/factory used in deserialization.
It’s very helpful when we need to deserialize some JSON that doesn’t exactly match the target entity we need to get.
we don’t want to change the entity itself – we just need a little more control over the unmarshalling process – by annotating the constructor with @JsonCreator and using the @JsonProperty annotation as well.<br><br>




