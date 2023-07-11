import { Component } from "@angular/core";

@Component({
    selector: 'app-server',
    templateUrl:'./server.component.html',
    styleUrls:['./server.component.css',],
})
export class ServerComponent {
    allowNewServer = true;
    serverid = 10;
    serverStatus = 'offline';
    serverCreated = false;
    constructor()
    {
        this.serverid++;
        setTimeout(()=>{this.allowNewServer =false},2000);
    }
    onCreateServer()
    {
        this.serverCreated = true;
        this.serverStatus = 'online';
    }
    
}