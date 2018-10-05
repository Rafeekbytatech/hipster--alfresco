/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytatech.clientonboard.client.dms.api;

import com.bytatech.clientonboard.client.dms.model.ActionBodyExec;
import com.bytatech.clientonboard.client.dms.model.ActionDefinitionEntry;
import com.bytatech.clientonboard.client.dms.model.ActionDefinitionList;
import com.bytatech.clientonboard.client.dms.model.ActionExecResultEntry;
import com.bytatech.clientonboard.client.dms.model.Error;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2018-10-04T10:32:12.785+05:30[Asia/Kolkata]")

@Api(value = "Actions", description = "the Actions API")
public interface ActionsApi {

    @ApiOperation(value = "Retrieve the details of an action definition", nickname = "actionDetails", notes = "**Note:** this endpoint is available in Alfresco 5.2 and newer versions.  Retrieve the details of the action denoted by **actionDefinitionId**. ", response = ActionDefinitionEntry.class, tags={ "actions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ActionDefinitionEntry.class),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 404, message = "**actionDefinitionId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/action-definitions/{actionDefinitionId}",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<ActionDefinitionEntry> actionDetails(@ApiParam(value = "The identifier of an action definition.",required=true) @PathVariable("actionDefinitionId") String actionDefinitionId);


    @ApiOperation(value = "Execute an action", nickname = "actionExec", notes = "**Note:** this endpoint is available in Alfresco 5.2 and newer versions.  Executes an action  An action may be executed against a node specified by **targetId**. For example:  ``` {   \"actionDefinitionId\": \"copy\",   \"targetId\": \"4c4b3c43-f18b-43ff-af84-751f16f1ddfd\",   \"params\": {    \"destination-folder\": \"34219f79-66fa-4ebf-b371-118598af898c\"   } } ```  Performing a POST with the request body shown above will result in the node identified by ```targetId``` being copied to the destination folder specified in the ```params``` object by the key ```destination-folder```.  **targetId** is optional, however, currently **targetId** must be a valid node ID. In the future, actions may be executed against different entity types or executed without the need for the context of an entity.   Parameters supplied to the action within the ```params``` object will be converted to the expected type, where possible using the DefaultTypeConverter class. In addition:  * Node IDs may be supplied in their short form (implicit workspace://SpacesStore prefix) * Aspect names may be supplied using their short form, e.g. cm:versionable or cm:auditable  In this example, we add the aspect ```cm:versionable``` to a node using the QName resolution mentioned above:  ``` {   \"actionDefinitionId\": \"add-features\",   \"targetId\": \"16349e3f-2977-44d1-93f2-73c12b8083b5\",   \"params\": {    \"aspect-name\": \"cm:versionable\"   } } ```  The ```actionDefinitionId``` is the ```id``` of an action definition as returned by the _list actions_ operations (e.g. GET /action-definitions).  The action will be executed **asynchronously** with a `202` HTTP response signifying that the request has been accepted successfully. The response body contains the unique ID of the action pending execution. The ID may be used, for example to correlate an execution with output in the server logs. ", response = ActionExecResultEntry.class, tags={ "actions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 202, message = "Action execution request accepted and pending execution. ", response = ActionExecResultEntry.class),
        @ApiResponse(code = 400, message = "Invalid parameter: **actionDefinitionId** missing but required by the action "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 404, message = "**actionDefinitionId** or **targetId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/action-executions",
        produces = "application/json", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<ActionExecResultEntry> actionExec(@ApiParam(value = "Action execution details" ,required=true )  @Valid @RequestBody ActionBodyExec actionBodyExec);


    @ApiOperation(value = "Retrieve list of available actions", nickname = "listActions", notes = "**Note:** this endpoint is available in Alfresco 5.2.2 and newer versions.  Gets a list of all available actions  The default sort order for the returned list is for actions to be sorted by ascending name. You can override the default by using the **orderBy** parameter.  You can use any of the following fields to order the results: * name * title ", response = ActionDefinitionList.class, tags={ "actions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ActionDefinitionList.class),
        @ApiResponse(code = 400, message = "Invalid parameter: value of **maxItems**, **skipCount** or **orderBy** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/action-definitions",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<ActionDefinitionList> listActions(@Min(0)@ApiParam(value = "The number of entities that exist in the collection before those included in this list.  If not supplied then the default value is 0. ", defaultValue = "0") @Valid @RequestParam(value = "skipCount", required = false, defaultValue="0") Integer skipCount,@Min(1)@ApiParam(value = "The maximum number of items to return in the list.  If not supplied then the default value is 100. ", defaultValue = "100") @Valid @RequestParam(value = "maxItems", required = false, defaultValue="100") Integer maxItems,@ApiParam(value = "A string to control the order of the entities returned in a list. You can use the **orderBy** parameter to sort the list by one or more fields.  Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order.  To sort the entities in a specific order, you can use the **ASC** and **DESC** keywords for any field. ") @Valid @RequestParam(value = "orderBy", required = false) List<String> orderBy,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);


    @ApiOperation(value = "Retrieve actions for a node", nickname = "nodeActions", notes = "**Note:** this endpoint is available in Alfresco 5.2 and newer versions.  Retrieve the list of actions that may be executed against the given **nodeId**.  The default sort order for the returned list is for actions to be sorted by ascending name. You can override the default by using the **orderBy** parameter.  You can use any of the following fields to order the results: * name * title ", response = ActionDefinitionList.class, tags={ "actions", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ActionDefinitionList.class),
        @ApiResponse(code = 400, message = "Invalid parameter: value of **maxItems**, **skipCount** or **orderBy** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 404, message = "**nodeId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/nodes/{nodeId}/action-definitions",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<ActionDefinitionList> nodeActions(@ApiParam(value = "The identifier of a node.",required=true) @PathVariable("nodeId") String nodeId,@Min(0)@ApiParam(value = "The number of entities that exist in the collection before those included in this list.  If not supplied then the default value is 0. ", defaultValue = "0") @Valid @RequestParam(value = "skipCount", required = false, defaultValue="0") Integer skipCount,@Min(1)@ApiParam(value = "The maximum number of items to return in the list.  If not supplied then the default value is 100. ", defaultValue = "100") @Valid @RequestParam(value = "maxItems", required = false, defaultValue="100") Integer maxItems,@ApiParam(value = "A string to control the order of the entities returned in a list. You can use the **orderBy** parameter to sort the list by one or more fields.  Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order.  To sort the entities in a specific order, you can use the **ASC** and **DESC** keywords for any field. ") @Valid @RequestParam(value = "orderBy", required = false) List<String> orderBy,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);

}
