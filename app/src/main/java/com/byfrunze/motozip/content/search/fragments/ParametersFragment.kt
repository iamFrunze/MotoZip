package com.byfrunze.motozip.content.search.fragments

import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import com.byfrunze.motozip.R
import com.byfrunze.motozip.content.search.presenters.ParametersPresenter
import com.byfrunze.motozip.content.search.views.ParametersView
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.dialog_fragment_parameters.*
import moxy.MvpAppCompatDialogFragment
import moxy.presenter.InjectPresenter

class ParametersFragment : MvpAppCompatDialogFragment(), ParametersView {

    @InjectPresenter
    lateinit var presenter: ParametersPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_fragment_parameters, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edt_region_parameters.threshold = 2
        edt_region_parameters.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.loadRegion(query = s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                presenter.loadRegion(query = s.toString())
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                presenter.loadRegion(query = s.toString())

            }

        })
    }

    override fun updateCount() {
    }

    override fun loadRegion(region: ArrayList<String>) {
        edt_region_parameters.setAdapter(ArrayAdapter(this.requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                region.toArray()))
    }
}