/**
 *  Copyright 2016 SmartBear Software
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.zno.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import cn.zno.exception.ApiException;
import cn.zno.exception.NotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/user")
@Api(value="/user", description = "Operations about user")
@Produces({"application/json"})
public class UserResource {




  @GET
  @Path("/{username}")
  @ApiOperation(value = "Get user by user name", 
    response = String.class)
  @ApiResponses(value = {
      @ApiResponse(code = 400, message = "Invalid username supplied"),
      @ApiResponse(code = 404, message = "User not found") })
  public Response getUserByName(
      @ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ", required = true) @PathParam("username") String username)
    throws ApiException {
    if (null != username) {
      return Response.ok().entity(username).build();
    } else {
      throw new NotFoundException(404, "User not found");
    }
  }

}
