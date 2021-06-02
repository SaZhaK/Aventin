// Это просто бэкап кода с wix

import {ok, created, serverError} from 'wix-http-functions';
import wixData from 'wix-data';

export function get_constructionSites(request) {
	const response = {
		"headers": {
			"Content-Type": "application/json"
		}
	};

	return wixData.query("Construction_sites").find().then(results => {
		response.body = {
			"test":results
		}
		return ok(response);
	})
}

export function post_constructionSites(request) {
  let response = {
    "headers": {
      "Content-Type": "application/json"
    }
  };

  	return request.body.json()
  	.then( (body) => {
    	return wixData.insert("Construction_sites", body);
    })
	.then(results => {
    	response.body = {
        "inserted": results
      };
      return created(response);
    }).catch( (error) => {
      response.body = {
        "error": error
      };
      return serverError(response);
    } );
}
