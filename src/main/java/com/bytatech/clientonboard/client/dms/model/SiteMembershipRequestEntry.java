package com.bytatech.clientonboard.client.dms.model;

import java.util.Objects;
import com.bytatech.clientonboard.client.dms.model.SiteMembershipRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SiteMembershipRequestEntry
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2018-10-04T10:32:12.785+05:30[Asia/Kolkata]")

public class SiteMembershipRequestEntry   {
  @JsonProperty("entry")
  private SiteMembershipRequest entry = null;

  public SiteMembershipRequestEntry entry(SiteMembershipRequest entry) {
    this.entry = entry;
    return this;
  }

  /**
   * Get entry
   * @return entry
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public SiteMembershipRequest getEntry() {
    return entry;
  }

  public void setEntry(SiteMembershipRequest entry) {
    this.entry = entry;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SiteMembershipRequestEntry siteMembershipRequestEntry = (SiteMembershipRequestEntry) o;
    return Objects.equals(this.entry, siteMembershipRequestEntry.entry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entry);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SiteMembershipRequestEntry {\n");
    
    sb.append("    entry: ").append(toIndentedString(entry)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

