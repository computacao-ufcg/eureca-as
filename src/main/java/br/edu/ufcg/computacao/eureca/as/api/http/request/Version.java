package br.edu.ufcg.computacao.eureca.as.api.http.request;

import br.edu.ufcg.computacao.eureca.as.constants.ApiDocumentation;
import br.edu.ufcg.computacao.eureca.as.constants.SystemConstants;
import br.edu.ufcg.computacao.eureca.as.core.ApplicationFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = Version.ENDPOINT)
@Api(description = ApiDocumentation.Version.API)
public class Version {

    public static final String ENDPOINT = SystemConstants.SERVICE_BASE_ENDPOINT + "version";

    private final Logger LOGGER = Logger.getLogger(Version.class);

    @ApiOperation(value = ApiDocumentation.Version.GET_OPERATION)
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<br.edu.ufcg.computacao.eureca.as.api.http.response.Version> getVersion() {

        String versionNumber = ApplicationFacade.getInstance().getVersionNumber();
        br.edu.ufcg.computacao.eureca.as.api.http.response.Version version =
                new br.edu.ufcg.computacao.eureca.as.api.http.response.Version(versionNumber);
        return new ResponseEntity<>(version, HttpStatus.OK);
    }
}
