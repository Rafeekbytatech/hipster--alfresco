/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytatech.clientonboard.client.dms.api;

import com.bytatech.clientonboard.client.dms.model.Error;
import com.bytatech.clientonboard.client.dms.model.GroupBodyCreate;
import com.bytatech.clientonboard.client.dms.model.GroupBodyUpdate;
import com.bytatech.clientonboard.client.dms.model.GroupEntry;
import com.bytatech.clientonboard.client.dms.model.GroupMemberEntry;
import com.bytatech.clientonboard.client.dms.model.GroupMemberPaging;
import com.bytatech.clientonboard.client.dms.model.GroupMembershipBodyCreate;
import com.bytatech.clientonboard.client.dms.model.GroupPaging;
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

@Api(value = "Groups", description = "the Groups API")
public interface GroupsApi {

    @ApiOperation(value = "Create a group", nickname = "createGroup", notes = "**Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.  Create a group.  The group id must start with \"GROUP\\_\". If this is omitted it will be added automatically. This format is also returned when listing groups or group memberships. It should be noted that the other group-related operations also expect the id to start with \"GROUP\\_\".  If one or more parentIds are specified then the group will be created and become a member of each of the specified parent groups.  If no parentIds are specified then the group will be created as a root group.  The group will be created in the **APP.DEFAULT** and **AUTH.ALF** zones.  You must have admin rights to create a group.  ", response = GroupEntry.class, tags={ "groups", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Successful response", response = GroupEntry.class),
        @ApiResponse(code = 400, message = "Invalid parameter: invalid **groupBodyCreate** "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 403, message = "User does not have permission to create a group"),
        @ApiResponse(code = 404, message = "**parentIds** does not exist "),
        @ApiResponse(code = 409, message = "**id** clashes with an existing group "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/groups",
        produces = "application/json", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<GroupEntry> createGroup(@ApiParam(value = "The group to create." ,required=true )  @Valid @RequestBody GroupBodyCreate groupBodyCreate,@ApiParam(value = "Returns additional information about the group. The following optional fields can be requested: * parentIds * zones ") @Valid @RequestParam(value = "include", required = false) List<String> include,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);


    @ApiOperation(value = "Create a group membership", nickname = "createGroupMembership", notes = "**Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.  Create a group membership (for an existing person or group) within a group **groupId**.  If the added group was previously a root group then it becomes a non-root group since it now has a parent.  It is an error to specify an **id** that does not exist.  You must have admin rights to create a group membership. ", response = GroupMemberEntry.class, tags={ "groups", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Successful response", response = GroupMemberEntry.class),
        @ApiResponse(code = 400, message = "Invalid parameter: **groupId** or **groupMembershipBodyCreate** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 403, message = "User does not have permission to create a group membership"),
        @ApiResponse(code = 404, message = "**groupId** or *id* (of group or person) does not exist "),
        @ApiResponse(code = 409, message = "Trying to modify a pre-defined system group, such as GROUP_EVERYONE. "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/groups/{groupId}/members",
        produces = "application/json", 
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<GroupMemberEntry> createGroupMembership(@ApiParam(value = "The identifier of a group.",required=true) @PathVariable("groupId") String groupId,@ApiParam(value = "The group membership to add (person or sub-group)." ,required=true )  @Valid @RequestBody GroupMembershipBodyCreate groupMembershipBodyCreate,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);


    @ApiOperation(value = "Delete a group", nickname = "deleteGroup", notes = "**Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.  Delete group **groupId**.   The option to cascade delete applies this recursively to any hierarchy of group members. In this case, removing a group member does not delete the person or sub-group itself. If a removed sub-group no longer has any parent groups then it becomes a root group.  You must have admin rights to delete a group. ", tags={ "groups", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Successful response"),
        @ApiResponse(code = 400, message = "Invalid parameter: **groupId** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 403, message = "User does not have permission to delete a group member"),
        @ApiResponse(code = 404, message = "**groupId** does not exist "),
        @ApiResponse(code = 409, message = "Trying to delete a pre-defined system group, such as GROUP_EVERYONE. "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/groups/{groupId}",
        produces = "application/json", 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteGroup(@ApiParam(value = "The identifier of a group.",required=true) @PathVariable("groupId") String groupId,@ApiParam(value = "If **true** then the delete will be applied in cascade to sub-groups. ", defaultValue = "false") @Valid @RequestParam(value = "cascade", required = false, defaultValue="false") Boolean cascade);


    @ApiOperation(value = "Delete a group membership", nickname = "deleteGroupMembership", notes = "**Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.  Delete group member **groupMemberId** (person or sub-group) from group **groupId**.  Removing a group member does not delete the person or sub-group itself.  If a removed sub-group no longer has any parent groups then it becomes a root group.  You must have admin rights to delete a group membership. ", tags={ "groups", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Successful response"),
        @ApiResponse(code = 400, message = "Invalid parameter: value of **groupId**, or **groupMemberId** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 403, message = "User does not have permission to delete a group membership"),
        @ApiResponse(code = 404, message = "**groupId** or **groupMemberId** does not exist "),
        @ApiResponse(code = 409, message = "Trying to delete a member of a pre-defined system group, such as GROUP_EVERYONE "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/groups/{groupId}/members/{groupMemberId}",
        produces = "application/json", 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteGroupMembership(@ApiParam(value = "The identifier of a group.",required=true) @PathVariable("groupId") String groupId,@ApiParam(value = "The identifier of a person or group.",required=true) @PathVariable("groupMemberId") String groupMemberId);


    @ApiOperation(value = "Get group details", nickname = "getGroup", notes = "**Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.  Get details for group **groupId**.  You can use the **include** parameter to return additional information. ", response = GroupEntry.class, tags={ "groups", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = GroupEntry.class),
        @ApiResponse(code = 400, message = "Invalid parameter: invalid **groupId** "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 404, message = "**groupId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/groups/{groupId}",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<GroupEntry> getGroup(@ApiParam(value = "The identifier of a group.",required=true) @PathVariable("groupId") String groupId,@ApiParam(value = "Returns additional information about the group. The following optional fields can be requested: * parentIds * zones ") @Valid @RequestParam(value = "include", required = false) List<String> include,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);


    @ApiOperation(value = "List memberships of a group", nickname = "listGroupMemberships", notes = "**Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.  Gets a list of the group memberships for the group **groupId**.  You can use the **where** parameter to filter the returned groups by **memberType**.  Example to filter by **memberType**, use any one of:  ``` (memberType='GROUP') (memberType='PERSON') ```  The default sort order for the returned list is for group members to be sorted by ascending displayName. You can override the default by using the **orderBy** parameter. You can specify one of the following fields in the **orderBy** parameter: * id * displayName ", response = GroupMemberPaging.class, tags={ "groups", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = GroupMemberPaging.class),
        @ApiResponse(code = 400, message = "Invalid parameter: value of **maxItems**, **skipCount**, **orderBy**, or **where** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 404, message = "**groupId** does not exist "),
        @ApiResponse(code = 405, message = "Trying to list all members of a pre-defined system group, such as GROUP_EVERYONE "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/groups/{groupId}/members",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<GroupMemberPaging> listGroupMemberships(@ApiParam(value = "The identifier of a group.",required=true) @PathVariable("groupId") String groupId,@Min(0)@ApiParam(value = "The number of entities that exist in the collection before those included in this list.  If not supplied then the default value is 0. ", defaultValue = "0") @Valid @RequestParam(value = "skipCount", required = false, defaultValue="0") Integer skipCount,@Min(1)@ApiParam(value = "The maximum number of items to return in the list.  If not supplied then the default value is 100. ", defaultValue = "100") @Valid @RequestParam(value = "maxItems", required = false, defaultValue="100") Integer maxItems,@ApiParam(value = "A string to control the order of the entities returned in a list. You can use the **orderBy** parameter to sort the list by one or more fields.  Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order.  To sort the entities in a specific order, you can use the **ASC** and **DESC** keywords for any field. ") @Valid @RequestParam(value = "orderBy", required = false) List<String> orderBy,@ApiParam(value = "A string to restrict the returned objects by using a predicate.") @Valid @RequestParam(value = "where", required = false) String where,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);


    @ApiOperation(value = "List group memberships", nickname = "listGroupMembershipsForPerson", notes = "**Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.            Gets a list of group membership information for person **personId**.    You can use the `-me-` string in place of `<personId>` to specify the currently authenticated user.   You can use the **include** parameter to return additional information.   You can use the **where** parameter to filter the returned groups by **isRoot**. For example, the following **where**  clause will return just the root groups:   ```  (isRoot=true)  ```   The **where** parameter can also be used to filter by ***zone***. This may be combined with isRoot to narrow  a result set even further. For example, the following where clause will only return groups belonging to the  `MY.ZONE` zone.   ```  where=(zones in ('MY.ZONE'))  ```   This may be combined with the isRoot filter, as shown below:   ```  where=(isRoot=false AND zones in ('MY.ZONE'))  ```   ***Note:*** restrictions include  * `AND` is the only supported operator when combining `isRoot` and `zones` filters  * Only one zone is supported by the filter  * The quoted zone name must be placed in parenthesis — a 400 error will result if these are omitted.    The default sort order for the returned list is for groups to be sorted by ascending displayName.  You can override the default by using the **orderBy** parameter. You can specify one or more of the following fields in the **orderBy** parameter:  * id  * displayName ", response = GroupPaging.class, tags={ "groups", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = GroupPaging.class),
        @ApiResponse(code = 400, message = "Invalid parameter: value of **maxItems**, **skipCount**, **orderBy** or **personId** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 404, message = "**personId** does not exist "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/people/{personId}/groups",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<GroupPaging> listGroupMembershipsForPerson(@ApiParam(value = "The identifier of a person.",required=true) @PathVariable("personId") String personId,@Min(0)@ApiParam(value = "The number of entities that exist in the collection before those included in this list.  If not supplied then the default value is 0. ", defaultValue = "0") @Valid @RequestParam(value = "skipCount", required = false, defaultValue="0") Integer skipCount,@Min(1)@ApiParam(value = "The maximum number of items to return in the list.  If not supplied then the default value is 100. ", defaultValue = "100") @Valid @RequestParam(value = "maxItems", required = false, defaultValue="100") Integer maxItems,@ApiParam(value = "A string to control the order of the entities returned in a list. You can use the **orderBy** parameter to sort the list by one or more fields.  Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order.  To sort the entities in a specific order, you can use the **ASC** and **DESC** keywords for any field. ") @Valid @RequestParam(value = "orderBy", required = false) List<String> orderBy,@ApiParam(value = "Returns additional information about the group. The following optional fields can be requested: * parentIds * zones ") @Valid @RequestParam(value = "include", required = false) List<String> include,@ApiParam(value = "A string to restrict the returned objects by using a predicate.") @Valid @RequestParam(value = "where", required = false) String where,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);


    @ApiOperation(value = "List groups", nickname = "listGroups", notes = "**Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.  Gets a list of groups.   You can use the **include** parameter to return additional information.  You can use the **where** parameter to filter the returned groups by **isRoot**. For example, the following **where**  clause will return just the root groups:    ``` (isRoot=true) ```  The **where** parameter can also be used to filter by ***zone***. This may be combined with isRoot to narrow a result set even further. For example, the following where clause will only return groups belonging to the `MY.ZONE` zone.  ``` where=(zones in ('MY.ZONE')) ```  This may be combined with the isRoot filter, as shown below:  ``` where=(isRoot=false AND zones in ('MY.ZONE')) ```  ***Note:*** restrictions include * `AND` is the only supported operator when combining `isRoot` and `zones` filters * Only one zone is supported by the filter * The quoted zone name must be placed in parenthesis — a 400 error will result if these are omitted.  The default sort order for the returned list is for groups to be sorted by ascending displayName. You can override the default by using the **orderBy** parameter. You can specify one of the following fields in the **orderBy** parameter: * id * displayName ", response = GroupPaging.class, tags={ "groups", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = GroupPaging.class),
        @ApiResponse(code = 400, message = "Invalid parameter: value of **maxItems** or **skipCount**, or **orderBy**, or **where** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/groups",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<GroupPaging> listGroups(@Min(0)@ApiParam(value = "The number of entities that exist in the collection before those included in this list.  If not supplied then the default value is 0. ", defaultValue = "0") @Valid @RequestParam(value = "skipCount", required = false, defaultValue="0") Integer skipCount,@Min(1)@ApiParam(value = "The maximum number of items to return in the list.  If not supplied then the default value is 100. ", defaultValue = "100") @Valid @RequestParam(value = "maxItems", required = false, defaultValue="100") Integer maxItems,@ApiParam(value = "A string to control the order of the entities returned in a list. You can use the **orderBy** parameter to sort the list by one or more fields.  Each field has a default sort order, which is normally ascending order. Read the API method implementation notes above to check if any fields used in this method have a descending default search order.  To sort the entities in a specific order, you can use the **ASC** and **DESC** keywords for any field. ") @Valid @RequestParam(value = "orderBy", required = false) List<String> orderBy,@ApiParam(value = "Returns additional information about the group. The following optional fields can be requested: * parentIds * zones ") @Valid @RequestParam(value = "include", required = false) List<String> include,@ApiParam(value = "A string to restrict the returned objects by using a predicate.") @Valid @RequestParam(value = "where", required = false) String where,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);


    @ApiOperation(value = "Update group details", nickname = "updateGroup", notes = "**Note:** this endpoint is available in Alfresco 5.2.1 and newer versions.  Update details (displayName) for group **groupId**.  You must have admin rights to update a group. ", response = GroupEntry.class, tags={ "groups", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = GroupEntry.class),
        @ApiResponse(code = 400, message = "Invalid parameter: **groupId** or **groupBodyCreate** is invalid "),
        @ApiResponse(code = 401, message = "Authentication failed"),
        @ApiResponse(code = 403, message = "User does not have permission to update a group"),
        @ApiResponse(code = 404, message = "**groupId** does not exist "),
        @ApiResponse(code = 409, message = "Trying to modify a pre-defined system group, such as GROUP_EVERYONE "),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/groups/{groupId}",
        produces = "application/json", 
        consumes = "application/json",
        method = RequestMethod.PUT)
    ResponseEntity<GroupEntry> updateGroup(@ApiParam(value = "The identifier of a group.",required=true) @PathVariable("groupId") String groupId,@ApiParam(value = "The group information to update." ,required=true )  @Valid @RequestBody GroupBodyUpdate groupBodyUpdate,@ApiParam(value = "Returns additional information about the group. The following optional fields can be requested: * parentIds * zones ") @Valid @RequestParam(value = "include", required = false) List<String> include,@ApiParam(value = "A list of field names.  You can use this parameter to restrict the fields returned within a response if, for example, you want to save on overall bandwidth.  The list applies to a returned individual entity or entries within a collection.  If the API method also supports the **include** parameter, then the fields specified in the **include** parameter are returned in addition to those specified in the **fields** parameter. ") @Valid @RequestParam(value = "fields", required = false) List<String> fields);

}
