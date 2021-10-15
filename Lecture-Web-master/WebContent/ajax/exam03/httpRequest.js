/**
 * Ajax통신과 관련된 함수의 집합
 */

let httpRequest = null

function getXMLHttpRequest() { // httpRequest 객체 받아오기 ( xml 타입의 )
	let httpRequest = null;
	if(window.XMLHttpRequest)
		httpRequest = new XMLHttpRequest()
	else if(window.ActiveXObject)
		httpRequest = new ActiveXObject("Microsoft.XMLHTTP")
	
	return httpRequest
}

function sendProcess(method, url, params, callback) {
	httpRequest = getXMLHttpRequest()
	httpRequest.onreadystatechange = callback
	
	let httpMethod = method
	if(httpMethod != 'GET' && httpMethod != 'POST')
		httpMethod = 'GET'
		
	let httpParams = ''
	if(params != null && params != '') {
		
		if(typeof(params) == 'string') { // 파라미터 값이 string일 경우,
			// ex ) name=홍길동&age=24
			paramArr = params.split('&') // name=홍길동 | age=24 로 분리
			for(let param of paramArr) { 
				pdata = param.split('=') // pdata[0] = name, pdata[1] = "홍길동" ...으로 분리
				if(httpParams != '') 
					httpParams += '&'
				httpParams += pdata[0] + '=' + encodeURIComponent(pdata[1]) // encodeURIComponent을 안해주면 uri가 바이트형식으로 됨
			}
		} else { // 파라미터 값이 객체 타입일 경우,
		
			// {name:'홍길동', age: 24} ==> name=홍길동&age=24
			for(let key in params) {
			//	console.log(key, params[key]) // params[key] -> key의 value값
				if(httpParams != '')
					httpParams += '&'
				httpParams += key + '=' + encodeURIComponent(params[key])
			}
		}
		
	}
	
	let httpUrl = url
	if(httpMethod == 'GET' && httpParams != '')
		httpUrl = url + '?' + httpParams
				
//	console.log(httpMethod, httpUrl, httpParams)				
				
	httpRequest.open(httpMethod, httpUrl, true)	
	if(httpMethod == 'GET')
		httpRequest.send(null)
	else if(httpMethod == 'POST') {
		httpRequest.setRequestHeader('Content-type', 'application/x-www-form-urlencoded')
		httpRequest.send(httpParams)
	}
}

