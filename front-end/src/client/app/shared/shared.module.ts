import { NgModule, ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { NameListService } from './name-list/index';
import { ApiService} from '../services/ApiService';

/**
* Do not specify providers for modules that might be imported by a lazy loaded module.
*/

@NgModule({
    imports: [CommonModule, RouterModule, FormsModule],
    declarations: [],
    exports: [CommonModule, FormsModule, RouterModule],
    providers:[CookieService, ApiService]
})

export class SharedModule {
    static forRoot(): ModuleWithProviders {
        return {
            ngModule: SharedModule,
            providers: [NameListService]
        };
    }
}
