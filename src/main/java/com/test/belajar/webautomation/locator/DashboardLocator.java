package com.test.belajar.webautomation.locator;

public interface DashboardLocator {
    String TITTLE_DASHBOARD = "//h1[normalize-space()='Dashboard']";
    String TITTLE_TEXT = "//h1[normalize-space()='%s']";

    String LIST_MENU = "//div[@class='px-2 py-4 overflow-y-auto']";
    String BUTTON_MENU = "//a[normalize-space()='%s']";

    String BTN_ASSIGNMENT_PARTNER = "//button[@id='btn-partner-assignment']";
    String BTN_ASSIGNMENT_TRUCK = "//button[@id='btn-assign-truck']";

    String TITLE_SOS_POP_UP = "//h2[normalize-space()='SOS Emergency Help']";
    String TXT_iSAFE_NO_SOS_POP_UP = "//tbody//tr[contains(.,'iSafe No')]/td[contains(normalize-space(),'%s')]";
    String TXT_SOS_TYPE_SOS_POP_UP = "//tbody//tr[contains(.,'SOS Type')]//span[contains(.,'%s')]";
    String BTN_LIHAT_SOS_POP_UP = "//button[.='Lihat']";

}