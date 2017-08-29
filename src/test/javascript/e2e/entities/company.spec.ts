import { browser, element, by, $ } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';
const path = require('path');

describe('Company e2e test', () => {

    let navBarPage: NavBarPage;
    let companyDialogPage: CompanyDialogPage;
    let companyComponentsPage: CompanyComponentsPage;
    const fileToUpload = '../../../../main/webapp/content/images/logo-jhipster.png';
    const absolutePath = path.resolve(__dirname, fileToUpload);
    

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load Companies', () => {
        navBarPage.goToEntity('company');
        companyComponentsPage = new CompanyComponentsPage();
        expect(companyComponentsPage.getTitle()).toMatch(/testApp.company.home.title/);

    });

    it('should load create Company dialog', () => {
        companyComponentsPage.clickOnCreateButton();
        companyDialogPage = new CompanyDialogPage();
        expect(companyDialogPage.getModalTitle()).toMatch(/testApp.company.home.createOrEditLabel/);
        companyDialogPage.close();
    });

    it('should create and save Companies', () => {
        companyComponentsPage.clickOnCreateButton();
        companyDialogPage.setNameInput('name');
        expect(companyDialogPage.getNameInput()).toMatch('name');
        companyDialogPage.setLogoInput(absolutePath);
        companyDialogPage.setThemaInput('thema');
        expect(companyDialogPage.getThemaInput()).toMatch('thema');
        companyDialogPage.save();
        expect(companyDialogPage.getSaveButton().isPresent()).toBeFalsy();
    }); 

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class CompanyComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('jhi-company div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class CompanyDialogPage {
    modalTitle = element(by.css('h4#myCompanyLabel'));
    saveButton = element(by.css('.modal-footer .btn.btn-primary'));
    closeButton = element(by.css('button.close'));
    nameInput = element(by.css('input#field_name'));
    logoInput = element(by.css('input#file_logo'));
    themaInput = element(by.css('input#field_thema'));

    getModalTitle() {
        return this.modalTitle.getAttribute('jhiTranslate');
    }

    setNameInput = function (name) {
        this.nameInput.sendKeys(name);
    }

    getNameInput = function () {
        return this.nameInput.getAttribute('value');
    }

    setLogoInput = function (logo) {
        this.logoInput.sendKeys(logo);
    }

    getLogoInput = function () {
        return this.logoInput.getAttribute('value');
    }

    setThemaInput = function (thema) {
        this.themaInput.sendKeys(thema);
    }

    getThemaInput = function () {
        return this.themaInput.getAttribute('value');
    }

    save() {
        this.saveButton.click();
    }

    close() {
        this.closeButton.click();
    }

    getSaveButton() {
        return this.saveButton;
    }
}
