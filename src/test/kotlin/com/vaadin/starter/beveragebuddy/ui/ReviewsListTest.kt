package com.vaadin.starter.beveragebuddy.ui

import com.github.karibu.testing.*
import com.github.mvysny.dynatest.DynaTest
import com.vaadin.flow.component.UI
import com.vaadin.flow.component.button.Button
import com.vaadin.starter.beveragebuddy.ui.reviews.ReviewEditorDialog
import com.vaadin.starter.beveragebuddy.ui.reviews.ReviewsList

class ReviewsListTest : DynaTest({

    usingApp()

    test("'new review' smoke test") {
        UI.getCurrent().navigate("")
        // this doesn't work, read more here: https://github.com/mvysny/karibu-testing/tree/master/karibu-testing-v10#polymer-templates
        //  _get<Button> { caption = "New review" } ._click()
        _get<ReviewsList>().addReview._click()

        // the dialog should have been opened
        _get<ReviewEditorDialog>()

        // this is just a smoke test, so let's close the dialog
        _get<Button> { caption = "Cancel" } ._click()

        _expectNone<ReviewEditorDialog>()
    }
})